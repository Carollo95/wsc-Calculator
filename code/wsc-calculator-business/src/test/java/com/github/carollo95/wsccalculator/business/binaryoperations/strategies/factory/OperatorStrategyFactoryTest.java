/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryoperations.strategies.factory;

import com.github.carollo95.wsccalculator.business.binaryoperations.enums.OPERATOR;
import com.github.carollo95.wsccalculator.business.binaryoperations.strategies.OperatorStrategy;
import com.github.carollo95.wsccalculator.business.binaryoperations.strategies.SubtractOperatorStrategy;
import com.github.carollo95.wsccalculator.business.binaryoperations.strategies.SumOperatorStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class OperatorStrategyFactoryTest {

    @InjectMocks
    private OperatorStrategyFactoryImpl target;

    @BeforeEach
    void setup() {
        this.target.registerStrategy(OPERATOR.SUM, new SumOperatorStrategy());
        this.target.registerStrategy(OPERATOR.SUBTRACT, new SubtractOperatorStrategy());
    }

    @Nested
    class RegisterStrategy {

        @Test
        void when_Register_then_TheClassIsRegistered() {
            final OperatorStrategy strategy = mock(OperatorStrategy.class);
            target.registerStrategy(OPERATOR.UNDEFINED, strategy);
            final OperatorStrategy actual = target.getStrategy(OPERATOR.UNDEFINED);
            assertSame(strategy, actual);
        }

        @Test
        void when_RegisterOperatorNull_then_NullPointerException() {
            final OperatorStrategy strategy = mock(OperatorStrategy.class);
            assertThrows(NullPointerException.class, () -> target.registerStrategy(null, strategy));
        }

        @Test
        void when_RegisterStrategyNull_then_NullPointerException() {
            assertThrows(NullPointerException.class, () -> target.registerStrategy(OPERATOR.UNDEFINED, null));
        }

        @Test
        void when_RegisterAlreadyRegisteredStrategy_then_IllegalArgumentException() {
            final OperatorStrategy strategy = mock(OperatorStrategy.class);
            assertThrows(IllegalArgumentException.class, () -> target.registerStrategy(OPERATOR.SUM, strategy));
        }
    }

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