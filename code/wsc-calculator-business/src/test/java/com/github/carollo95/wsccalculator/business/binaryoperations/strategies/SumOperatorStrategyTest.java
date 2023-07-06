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
class SumOperatorStrategyTest {

    @InjectMocks
    private SumOperatorStrategy target;

    @Mock
    private OperatorStrategyFactory operatorStrategyFactory;


    @Nested
    class Register {

        @Test
        void when_Called_TheBeanIsRegisteredForSum() {
            target.register();
            verify(operatorStrategyFactory).registerStrategy(OPERATOR.SUM, target);
        }

    }
    @Nested
    class Operate {

        @Test
        void when_null_then_NullPointerException() {
            assertThrows(NullPointerException.class, () -> target.operate(null));
        }

        @Test
        void when_EmptyList_then_Zero() {
            BigDecimal actual = target.operate(List.of());
            assertEquals(BigDecimal.ZERO, actual);
        }

        @Test
        void when_OneElement_then_TheSameElement() {
            BigDecimal o1 = new BigDecimal("12.5");
            BigDecimal actual = target.operate(List.of(o1));
            assertEquals(o1, actual);
        }

        @Test
        void when_TwoElements_then_TheSumOfBoth() {
            BigDecimal o1 = new BigDecimal("12.5");
            BigDecimal o2 = new BigDecimal("21.5");

            BigDecimal actual = target.operate(List.of(o1, o2));

            BigDecimal expected = new BigDecimal("34.0");
            assertEquals(expected, actual);
        }

        @Test
        void when_ThreeElements_then_TheSumOfThem() {
            BigDecimal o1 = new BigDecimal("12.5");
            BigDecimal o2 = new BigDecimal("21.5");
            BigDecimal o3 = new BigDecimal("10.8");

            BigDecimal actual = target.operate(List.of(o1, o2, o3));

            BigDecimal expected = new BigDecimal("44.8");
            assertEquals(expected, actual);
        }
    }

}