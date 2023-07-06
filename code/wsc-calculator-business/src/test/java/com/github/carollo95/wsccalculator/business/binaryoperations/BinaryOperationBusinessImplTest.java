/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryoperations;

import com.github.carollo95.wsccalculator.business.binaryoperations.beans.OperateParametersBean;
import com.github.carollo95.wsccalculator.business.binaryoperations.enums.OPERATOR;
import com.github.carollo95.wsccalculator.business.binaryoperations.strategies.OperatorStrategy;
import com.github.carollo95.wsccalculator.business.binaryoperations.strategies.OperatorStrategyFactory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BinaryOperationBusinessImplTest {

    @InjectMocks
    private BinaryOperationBusinessImpl target;

    @Mock
    private OperatorStrategyFactory operatorStrategyFactory;

    @Nested
    class OperateBinary {
        @Test
        void when_null_then_NullPointerException() {
            assertThrows(NullPointerException.class, () -> target.operateBinary(null));
        }

        @Test
        void when_OperatorIsNull_then_NullPointerException() {
            final List<BigDecimal> operands = List.of(new BigDecimal("12.1"), new BigDecimal("21.2"));
            final OperateParametersBean params = OperateParametersBean.builder()
                    .operands(operands)
                    .build();

            assertThrows(NullPointerException.class, () -> target.operateBinary(params));
        }

        @Test
        void when_OperatorIsUNDEFINED_then_IllegalArgumentException() {
            final List<BigDecimal> operands = List.of(new BigDecimal("12.1"), new BigDecimal("21.2"));
            final OperateParametersBean params = OperateParametersBean.builder()
                    .operator(OPERATOR.UNDEFINED)
                    .operands(operands)
                    .build();

            assertThrows(IllegalArgumentException.class, () -> target.operateBinary(params));
        }
        @Test
        void when_OperandsIsNull_then_NullPointerException() {
            final OperateParametersBean params = OperateParametersBean.builder()
                    .operator(OPERATOR.SUM)
                    .build();

            assertThrows(NullPointerException.class, () -> target.operateBinary(params));
        }

        @Test
        void when_OperatorIsNotNull_then_DelegatesOnTheStrategy() {
            List<BigDecimal> operands = List.of(new BigDecimal("12.1"), new BigDecimal("21.2"));
            final OperateParametersBean params = OperateParametersBean.builder()
                    .operator(OPERATOR.SUM)
                    .operands(operands)
                    .build();
            BigDecimal expected = new BigDecimal("33.3");

            OperatorStrategy operatorStrategyMock = mock(OperatorStrategy.class);
            when(operatorStrategyMock.operate(operands)).thenReturn(expected);

            when(operatorStrategyFactory.getStrategy(OPERATOR.SUM)).thenReturn(operatorStrategyMock);

            BigDecimal actual = target.operateBinary(params);

            assertEquals(expected, actual);
        }
    }

}