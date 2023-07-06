/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryoperations;

import com.github.carollo95.wsccalculator.business.binaryoperations.beans.OperateParametersBean;
import com.github.carollo95.wsccalculator.business.binaryoperations.beans.OperateResultBean;

/**
 * Business logic for binary operations
 */
public interface BinaryOperationBusiness {
    /**
     * Operates a binary operation for the given parameters
     * @param operateParameters the parameters to operate on
     * @return the result of the operation
     */
    OperateResultBean operateBinary(final OperateParametersBean operateParameters);
}
