package vttp.paf.day22workshop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.paf.day22workshop.Repository.RsvpRepository;
import vttp.paf.day22workshop.models.RecordNotFoundException;
import vttp.paf.day22workshop.models.Rsvp;

@Service
public class RsvpService {
    
    @Autowired
    private RsvpRepository rsvpRepository;

    public List<Rsvp> getAllRsvp() {
        return rsvpRepository.getAllRsvp();
    }

    public List<Rsvp> getAllRsvpsByName(String name){
        return rsvpRepository.getAllRsvpByName(name);
    }

    public boolean addNewRsvp(Rsvp rsvp){
        return rsvpRepository.addNewRsvp(rsvp);
    }

    public Rsvp getRsvpByEmail(String email){
        return rsvpRepository.getRsvpByEmail(email).orElseThrow(() -> new RecordNotFoundException("Rsvp not found"));
    }
    
    public boolean updateNewRsvp(Rsvp rsvp){
        return rsvpRepository.updateRsvp(rsvp);
    }

    public int getRsvpCount(){
        return rsvpRepository.getRsvpCount();
    }
}
