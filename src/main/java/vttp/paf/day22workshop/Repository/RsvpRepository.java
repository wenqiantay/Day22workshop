package vttp.paf.day22workshop.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp.paf.day22workshop.models.Rsvp;

@Repository
public class RsvpRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Rsvp> getAllRsvp() {

        List<Rsvp> rsvpList = new ArrayList<>();
        SqlRowSet rs = jdbcTemplate.queryForRowSet(Queries.SQL_GET_ALL_RSVP);

        while (rs.next()) {
            Rsvp rsvp = new Rsvp();
            rsvp.setReservationId(rs.getInt("reservation_id"));
            rsvp.setFullName(rs.getString("full_name"));
            rsvp.setEmail(rs.getString("email"));
            rsvp.setPhoneNumber(rs.getString("phone"));
            rsvp.setConfirmationDate(rs.getDate("confirmation_date"));
            rsvp.setComments(rs.getString("comments"));
            rsvpList.add(rsvp);
        }

        return rsvpList;
    }

    public List<Rsvp> getAllRsvpByName(String name) {

        List<Rsvp> rsvpList = new ArrayList<>();
        SqlRowSet rs = jdbcTemplate.queryForRowSet(Queries.SQL_GET_RSVP_BY_NAME, name);

        while (rs.next()) {
            Rsvp rsvp = new Rsvp();
            rsvp.setReservationId(rs.getInt("reservation_id"));
            rsvp.setFullName(rs.getString("full_name"));
            rsvp.setEmail(rs.getString("email"));
            rsvp.setPhoneNumber(rs.getString("phone"));
            rsvp.setConfirmationDate(rs.getDate("confirmation_date"));
            rsvp.setComments(rs.getString("comments"));
            rsvpList.add(rsvp);
        }

        return rsvpList;
    }

    public Boolean addNewRsvp(Rsvp rsvp) {

        return jdbcTemplate.update(Queries.SQL_ADD_NEW_RSVP, rsvp.getFullName(), rsvp.getEmail(), rsvp.getPhoneNumber(),
                rsvp.getConfirmationDate(), rsvp.getComments()) > 0;
    }

    public Optional<Rsvp> getRsvpByEmail(String email) {
        String sql = "SELECT * FROM rsvp WHERE email = ?";

        try {
            // If the row is found, return it wrapped in an Optional
            Rsvp rsvp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Rsvp.class), email);
            return Optional.ofNullable(rsvp); 
            
        } catch (EmptyResultDataAccessException e) {

            // If no result is found, return an empty Optional
            return Optional.empty();
        }
    }

    public Boolean updateRsvp(Rsvp rsvp) {

        return jdbcTemplate.update(Queries.SQL_UPDATE_RSVP, rsvp.getFullName(), rsvp.getEmail(), rsvp.getPhoneNumber(),
                rsvp.getConfirmationDate(), rsvp.getComments()) > 0;
    }

    public int getRsvpCount() {

        return jdbcTemplate.queryForObject(Queries.SQL_GET_RSVP_COUNT, Integer.class);
    }
}
