/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.binaryoperations;

import com.github.carollo95.wsccalculator.binaryoperations.beans.OperateParametersBean;

import java.math.BigDecimal;

/**
 * Business logic for binary operations
 */
public interface BinaryOperationBusiness {
    /**
     * Operates a binary operation for the given parameters
     * @param operateParameters the parameters to operate on
     * @return the result of the operation
     */
    BigDecimal operateBinary(final OperateParametersBean operateParameters);
}
