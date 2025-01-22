package vttp.paf.day22workshop.Repository;

public class Queries {
    
    public static final String SQL_GET_ALL_RSVP = """
            SELECT * FROM RSVP
            """;

    public static final String SQL_GET_RSVP_BY_NAME = """
            SELECT * FROM rsvp WHERE full_name like ?
            """;

    public static final String SQL_ADD_NEW_RSVP = """
            insert into rsvp(full_name, email, phone, confirmation_date, comments) values (?, ?, ?, ?, ?);
            """;
    public static final String SQL_UPDATE_RSVP = """
            update rsvp set full_name= ?, email= ?, phone= ?, confirmation_date= ?, comments= ?
            """;
    public static final String SQL_GET_RSVP_BY_EMAIL = """
            SELECT * FROM rsvp WHERE email = ?
            """;
    public static final String SQL_GET_RSVP_COUNT = """
            SELECT COUNT(*) FROM rsvp
            """;
}

