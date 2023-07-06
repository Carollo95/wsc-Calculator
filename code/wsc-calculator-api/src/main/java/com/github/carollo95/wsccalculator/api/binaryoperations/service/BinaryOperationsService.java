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

package com.github.carollo95.wsccalculator.api.binaryoperations.service;

import com.github.carollo95.wsccalculator.api.binaryoperations.dto.OperateParametersDTO;
import com.github.carollo95.wsccalculator.api.binaryoperations.dto.OperateResultDTO;

/**
 * Service layer faro the binary operations
 */
public interface BinaryOperationsService {

    /**
     * Operates a binary operation for the given parameters
     * @param operateParameters the parameters to operate on
     * @return the result of the operation
     */
    OperateResultDTO operateBinary(final OperateParametersDTO operateParameters);

}
