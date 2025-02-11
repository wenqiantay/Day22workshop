package vttp.paf.day22workshop.Controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vttp.paf.day22workshop.Services.RsvpService;
import vttp.paf.day22workshop.models.Rsvp;

@RestController
@RequestMapping(path = "/api")
public class RsvpRestController {

    @Autowired
    private RsvpService rsvpService;

    @GetMapping("/rsvps")
    public ResponseEntity<List<Rsvp>> getAllRsvps() {

        List<Rsvp> rsvpList = rsvpService.getAllRsvp();

        return ResponseEntity.ok().body(rsvpList);
    }

    @GetMapping("/rsvp")
    public ResponseEntity<List<Rsvp>> getAllRsvpsByName(@RequestParam String q) {

        List<Rsvp> rsvpList = rsvpService.getAllRsvpsByName(q);

        return ResponseEntity.ok().body(rsvpList);
    }

    @PostMapping("/rsvp")
    public ResponseEntity<Boolean> addNewRsvp(@RequestParam String fullName,
                                                @RequestParam String email,
                                                @RequestParam String phoneNumber,
                                                @RequestParam Date confirmationDate,
                                                @RequestParam String comments) {

        Rsvp rsvp = new Rsvp();
        rsvp.setFullName(fullName);
        rsvp.setEmail(email);
        rsvp.setPhoneNumber(phoneNumber);
        rsvp.setConfirmationDate(confirmationDate);
        rsvp.setComments(comments);

        Boolean savedRsvp = rsvpService.addNewRsvp(rsvp);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(savedRsvp);

    }

    //Cannot edit the email -- email is unique(maybe take out the email params)
    @PutMapping("/rsvp/{user_email}")
    public ResponseEntity<Boolean> updateExisingRsvpByEmail(@PathVariable("user_email")String queryEmail,
                                                            @RequestParam String fullName,
                                                            @RequestParam String email,
                                                            @RequestParam String phoneNumber,
                                                            @RequestParam Date confirmationDate,
                                                            @RequestParam String comments){
    
        Rsvp existingRsvp = rsvpService.getRsvpByEmail(email);

        if(existingRsvp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } 

        existingRsvp.setFullName(fullName);
        existingRsvp.setEmail(email);
        existingRsvp.setPhoneNumber(phoneNumber);
        existingRsvp.setConfirmationDate(confirmationDate);
        existingRsvp.setComments(comments);

        Boolean updatedRsvp = rsvpService.updateNewRsvp(existingRsvp);
        

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(updatedRsvp);
        

    
    }

    @GetMapping("/rsvp/count")
    public ResponseEntity<Integer> getRsvpCount(){

        int rsvpCount = rsvpService.getRsvpCount();

        return ResponseEntity.ok().body(rsvpCount);
    }
}
