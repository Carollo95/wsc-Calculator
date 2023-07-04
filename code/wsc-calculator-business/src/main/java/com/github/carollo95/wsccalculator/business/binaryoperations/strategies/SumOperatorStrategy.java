/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryoperations.strategies;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Operation strategy for the SUM
 */
public class SumOperatorStrategy implements OperatorStrategy {

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal operate(List<BigDecimal> operands) {
        Objects.requireNonNull(operands, "The operands must not be null");

        return operands
                .stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
