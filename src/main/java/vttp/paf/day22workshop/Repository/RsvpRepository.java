package vttp.paf.day22workshop.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp.paf.day22workshop.models.Rsvp;

@Repository
public class RsvpRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Rsvp> getAllRsvp(){

        List<Rsvp> rsvpList = new ArrayList<>();
        SqlRowSet rs = jdbcTemplate.queryForRowSet(Queries.SQL_GET_ALL_RSVP);

        while(rs.next()){
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

        while(rs.next()){
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
}
