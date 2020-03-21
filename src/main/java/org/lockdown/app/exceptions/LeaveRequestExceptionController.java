package org.lockdown.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by @author Jorge Machado on 21.03.20.
 */

@ControllerAdvice
class LeaveTicketExceptionController {


    @ExceptionHandler( value = DomainException.class)
    public ResponseEntity<Object> exception(DomainException exception) {
        return new ResponseEntity<>(exception.toString(), HttpStatus.BAD_REQUEST);
    }

}
