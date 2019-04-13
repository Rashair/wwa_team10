package pl.allegro.braincode.team10.controller.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.allegro.braincode.team10.exception.SearchingGoogleCoordinatesException;
import pl.allegro.braincode.team10.exception.SearchingInPostDeliveryException;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = SearchingInPostDeliveryException.class)
    public ResponseEntity<Object> handleSearchingInPostDeliveryException(SearchingInPostDeliveryException ex) {
        return new ResponseEntity<>("Could not perform search query of InPost delivery places", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<Object> handleSearchingInPostDeliveryException(IllegalArgumentException ex) {
        return new ResponseEntity<>("IllegalArgument " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = SearchingGoogleCoordinatesException.class)
    public ResponseEntity<Object> handleSearchingGoogleCoordinatesException(SearchingGoogleCoordinatesException ex) {
        return new ResponseEntity<>("Could not perform search query of coordinates from address", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
