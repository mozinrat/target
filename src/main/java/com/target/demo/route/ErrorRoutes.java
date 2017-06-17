package com.target.demo.route;

import com.target.demo.model.CustomError;
import org.springframework.core.codec.DecodingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by rohit on 6/16/17.
 */
@ControllerAdvice
public class ErrorRoutes {

    @ExceptionHandler(DecodingException.class)
    public ResponseEntity<CustomError> validationRouter(Exception e){
        return new ResponseEntity(new CustomError(HttpStatus.BAD_REQUEST.name(),"input is not valid"),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<CustomError> validationRouter2(Exception e){
        return new ResponseEntity(new CustomError(HttpStatus.BAD_REQUEST.name(),e.getLocalizedMessage()),HttpStatus.BAD_REQUEST);
    }
}
