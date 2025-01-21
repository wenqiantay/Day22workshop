package vttp.paf.day22workshop.models;

import java.sql.Date;

public class Rsvp {
    
    private int reservationId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private Date confirmationDate;
    private String comments;

    public int getReservationId() {
        return reservationId;
    }
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Date getConfirmationDate() {
        return confirmationDate;
    }
    public void setConfirmationDate(Date confirmationDate) {
        this.confirmationDate = confirmationDate;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    @Override
    public String toString() {
        return "Rsvp [reservationId=" + reservationId + ", fullName=" + fullName + ", email=" + email + ", phoneNumber="
                + phoneNumber + ", confirmationDate=" + confirmationDate + ", comments=" + comments + "]";
    }
    
}
