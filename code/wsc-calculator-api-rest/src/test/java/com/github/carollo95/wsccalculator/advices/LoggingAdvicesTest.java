/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.advices;

import io.corp.calculator.TracerImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoggingAdvicesTest {

    @InjectMocks
    private LoggingAdvices target;

    @Mock
    private TracerImpl tracer;

    @Nested
    class controllerLoggingAdvice {

        @Mock
        private ProceedingJoinPoint proceedingJoinPoint;

        @Captor
        private ArgumentCaptor<String> traceCaptor;

        @Test
        void when_operationSuccessful_then_LoggingTheSuccess() throws Throwable {
            Object result = "result";
            mockProceedingJoinPointCommons();
            when(proceedingJoinPoint.proceed()).thenReturn(result);

            doNothing().when(tracer).trace(traceCaptor.capture());

            Object actual = target.controllerLoggingAdvice(proceedingJoinPoint);

            assertEquals(result, actual);
            String capturedTrace = traceCaptor.getValue();
            //Avoiding the validation of the time with 2 asserts
            assertTrue(capturedTrace.startsWith("Object::methodName(arg1, arg2, null) finished in "));
            assertTrue(capturedTrace.endsWith("Returned: result)"));
        }

        @Test
        void when_operationFails_then_LoggingTheFailure() throws Throwable {
            mockProceedingJoinPointCommons();
            when(proceedingJoinPoint.proceed()).thenThrow(new NullPointerException("failure"));

            doNothing().when(tracer).trace(traceCaptor.capture());

            assertThrows(NullPointerException.class, () -> target.controllerLoggingAdvice(proceedingJoinPoint));

            String capturedTrace = traceCaptor.getValue();
            assertTrue(capturedTrace.startsWith("Object::methodName(arg1, arg2, null) finished in "));
            assertTrue(capturedTrace.contains("Threw: java.lang.NullPointerException: failure"));
        }

        private void mockProceedingJoinPointCommons() {
            Signature signatureMock = mock(Signature.class);
            when(signatureMock.getName()).thenReturn("methodName");
            Class clazz = Object.class;
            when(signatureMock.getDeclaringType()).thenReturn(clazz);
            when(proceedingJoinPoint.getSignature()).thenReturn(signatureMock);
            when(proceedingJoinPoint.getArgs()).thenReturn(new String[]{"arg1", "arg2", null});
        }

    }

}