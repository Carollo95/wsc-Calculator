/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryoperations.strategies;

import java.math.BigDecimal;
import java.util.List;

/**
 * Abstract strategy for operations
 */
public interface OperatorStrategy {

    /**
     * Operates the operands
     * @param operands the list of operands
     * @return the result of the operation
     */
    BigDecimal operate (List<BigDecimal> operands);
}
