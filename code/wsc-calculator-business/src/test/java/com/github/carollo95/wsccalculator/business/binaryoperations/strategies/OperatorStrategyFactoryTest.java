/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryoperations.strategies;

import com.github.carollo95.wsccalculator.business.binaryoperations.enums.OPERATOR;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class OperatorStrategyFactoryTest {

    @InjectMocks
    private OperatorStrategyFactory target;

    @Nested
    class GetStrategy {
        @Test
        void when_null_then_NullPointerException() {
            assertThrows(NullPointerException.class, () -> target.getStrategy(null));
        }

        @Test
        void when_UNDEFINED_then_IllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> target.getStrategy(OPERATOR.UNDEFINED));
        }

        @Test
        void when_SUM_then_TheSumStrategy() {
            OperatorStrategy strategy = target.getStrategy(OPERATOR.SUM);
            Class<? extends OperatorStrategy> strategyClass = strategy.getClass();
            assertEquals(SumOperatorStrategy.class, strategyClass);
        }

        @Test
        void when_SUBTRACT_then_TheSubtractStrategy() {
            OperatorStrategy strategy = target.getStrategy(OPERATOR.SUBTRACT);
            Class<? extends OperatorStrategy> strategyClass = strategy.getClass();
            assertEquals(SubtractOperatorStrategy.class, strategyClass);
        }
    }

}