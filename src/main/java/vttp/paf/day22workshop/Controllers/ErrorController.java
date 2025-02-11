package vttp.paf.day22workshop.Controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import vttp.paf.day22workshop.models.RecordNotFoundException;

@RestControllerAdvice
public class ErrorController {
    
    @ExceptionHandler(
        exception = {RecordNotFoundException.class},
        produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<String> handleRecordNotFound(RecordNotFoundException ex) {
        JsonObject payload = Json.createObjectBuilder()
                            .add("message", ex.getMessage())
                            .build();
        return ResponseEntity.status(404).body(payload.toString());
    }

}
