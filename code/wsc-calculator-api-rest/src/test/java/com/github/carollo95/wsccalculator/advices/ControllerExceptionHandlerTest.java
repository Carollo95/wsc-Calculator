/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.advices;

import com.github.carollo95.wsccalculator.restdto.ErrorInformationRestDTO;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ControllerExceptionHandlerTest {

    @InjectMocks
    private ControllerExceptionHandler target;


    @Nested
    class BadParametersHandler {

        @Test
        void when_Exception_then_400WithInfo() {
            ResponseEntity<ErrorInformationRestDTO> actual = target.badParametersHandler(new Exception());


            ErrorInformationRestDTO expectedBody = new ErrorInformationRestDTO("The parameters are not valid");

            assertEquals(HttpStatusCode.valueOf(400), actual.getStatusCode());
            assertEquals(expectedBody, actual.getBody());
        }

    }

    @Nested
    class OperationNotValidHandler {

        @Test
        void when_Exception_then_405WithInfo() {
            ResponseEntity<ErrorInformationRestDTO> actual = target.operationNotValidHandler(new Exception());

            ErrorInformationRestDTO expectedBody = new ErrorInformationRestDTO("The operation is not valid");

            assertEquals(HttpStatusCode.valueOf(405), actual.getStatusCode());
            assertEquals(expectedBody, actual.getBody());
        }

    }

    @Nested
    class GenericExceptionHandler {

        @Test
        void when_Exception_then_500WithInfo() {
            ResponseEntity<ErrorInformationRestDTO> actual = target.genericExceptionHandler(new Exception());

            ErrorInformationRestDTO expectedBody = new ErrorInformationRestDTO("An internal error occurred. Please contact the administrator");

            assertEquals(HttpStatusCode.valueOf(500), actual.getStatusCode());
            assertEquals(expectedBody, actual.getBody());
        }

    }

}