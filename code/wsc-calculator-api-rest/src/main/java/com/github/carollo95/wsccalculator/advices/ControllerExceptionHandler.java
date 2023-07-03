/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Advice that captures all the exceptions thrown from the Controller layer and properly returns the appropriate response.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private ControllerExceptionHandler() {
        //Not instantiable
    }

    /**
     * Handler for the bad requests
     *
     * @param e the exception
     * @return the response with the exception message
     */
    @ExceptionHandler({
            HttpMessageNotReadableException.class,
            MethodArgumentNotValidException.class,
            HttpMediaTypeNotSupportedException.class
    })
    private ResponseEntity<String> badParametersHandler(final Exception e) {
        return ResponseEntity.badRequest().body("The parameters are not valid");
    }

    /**
     * Handler for invalid operation
     * @param e the exception
     * @return the response with the exception message
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    private ResponseEntity<String> operationNotValidHandler(final Exception e) {
        return ResponseEntity.status(HttpStatusCode.valueOf(405)).body("The operation is not valid");
    }

    /**
     * Generic exception handler.
     *
     * @param e the exception
     * @return an error response entity
     */
    @ExceptionHandler
    private ResponseEntity<String> genericExceptionHandler(final Exception e) {
        return new ResponseEntity<>("An internal error occurred. Please contact the administrator",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
