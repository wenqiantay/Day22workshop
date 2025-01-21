package vttp.paf.day22workshop.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vttp.paf.day22workshop.Services.RsvpService;
import vttp.paf.day22workshop.models.Rsvp;

@RestController
@RequestMapping(path="/api")
public class RsvpRestController {

    @Autowired
    private RsvpService rsvpService;
    
    @GetMapping("/rsvps")
    public ResponseEntity<List<Rsvp>> getAllRsvps(){
        
        List<Rsvp> rsvpList =  rsvpService.getAllRsvp();

        return ResponseEntity.ok().body(rsvpList);
    }

    @GetMapping("/rsvp")
    public ResponseEntity<List<Rsvp>> getAllRsvpsByName(@RequestParam String q){

        List<Rsvp> rsvpList = rsvpService.getAllRsvpsByName(q);

        return ResponseEntity.ok().body(rsvpList);
    }
}
