package vitorluc.moneyapi.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import vitorluc.moneyapi.services.exceptions.ObjectNotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExcecptionHandler {


    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> notFound(ObjectNotFoundException e, HttpServletRequest request){
        StandardError error = new StandardError();
        HttpStatus status = HttpStatus.NOT_FOUND;
        error.setError("Objeto não encontrado");
        error.setMessage(e.getMessage());
        error.setStatus(status.value());
        error.setTimestamp(LocalDateTime.now());
        error.setPath(request.getRequestURI());
        return  ResponseEntity.status(status).body(error);
    }
}
