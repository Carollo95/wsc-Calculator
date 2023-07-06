/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryoperations.strategies.factory;

import com.github.carollo95.wsccalculator.business.binaryoperations.enums.OPERATOR;
import com.github.carollo95.wsccalculator.business.binaryoperations.strategies.OperatorStrategy;

/**
 * Factory for the delivery of operator strategies
 */
public interface OperatorStrategyFactory {

    /**
     * Registers a new strategy to the factory associated to a given operation
     *
     * @param operatorTarget the operation that the strategy handles
     */
    void registerStrategy(final OPERATOR operatorTarget, final OperatorStrategy strategy);


    /**
     * Returns the correct strategy for the operation
     *
     * @param operator the operator
     * @return the strategy to operate
     */
    OperatorStrategy getStrategy(OPERATOR operator);

}
