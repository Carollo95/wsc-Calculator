/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryoperations.strategies;

import java.math.BigDecimal;
import java.util.List;

/**
 * Operation strategy for the SUM
 */
public class SumOperatorStrategy implements OperatorStrategy {

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal operate(List<BigDecimal> operands) {
        BigDecimal result = BigDecimal.ZERO;

        for (BigDecimal operand : operands) {
            result = result.add(operand);
        }

        return result;
    }
}
