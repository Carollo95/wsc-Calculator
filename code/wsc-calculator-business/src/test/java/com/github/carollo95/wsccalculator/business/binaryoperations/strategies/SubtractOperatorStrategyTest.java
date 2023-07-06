/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryoperations.strategies;

import com.github.carollo95.wsccalculator.business.binaryoperations.enums.OPERATOR;
import com.github.carollo95.wsccalculator.business.binaryoperations.strategies.factory.OperatorStrategyFactory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SubtractOperatorStrategyTest {

    @InjectMocks
    private SubtractOperatorStrategy target;

    @Mock
    private OperatorStrategyFactory operatorStrategyFactory;


    @Nested
    class Register {

        @Test
        void when_Called_TheBeanIsRegisteredForSubtract() {
            target.register();
            verify(operatorStrategyFactory).registerStrategy(OPERATOR.SUBTRACT, target);
        }

    }

    @Nested
    class Operate {

        @Test
        void when_null_then_NullPointerException() {
            assertThrows(NullPointerException.class, () -> target.operate(null));
        }

        @Test
        void when_EmptyList_then_IllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> target.operate(List.of()));
        }

        @Test
        void when_OneElement_then_TheSameElement() {
            BigDecimal o1 = new BigDecimal("12.5");
            BigDecimal actual = target.operate(List.of(o1));
            assertEquals(o1, actual);
        }

        @Test
        void when_TwoElements_then_TheFirstMinusTheSecond() {
            BigDecimal o1 = new BigDecimal("31.12");
            BigDecimal o2 = new BigDecimal("18.3");

            BigDecimal actual = target.operate(List.of(o1, o2));

            BigDecimal expected = new BigDecimal("12.82");
            assertEquals(expected, actual);
        }

        @Test
        void when_ThreeElements_then_TheFirstElementMinusTheRest() {
            BigDecimal o1 = new BigDecimal("31.12");
            BigDecimal o2 = new BigDecimal("18.3");
            BigDecimal o3 = new BigDecimal("10.8");

            BigDecimal actual = target.operate(List.of(o1, o2, o3));

            BigDecimal expected = new BigDecimal("2.02");
            assertEquals(expected, actual);
        }
    }

}