package vttp.paf.day22workshop.Repository;

public class Queries {
    
    public static final String SQL_GET_ALL_RSVP = """
            SELECT * FROM RSVP
            """;

    public static final String SQL_GET_RSVP_BY_NAME = """
            SELECT * FROM rsvp WHERE full_name like ?
            """;
}
