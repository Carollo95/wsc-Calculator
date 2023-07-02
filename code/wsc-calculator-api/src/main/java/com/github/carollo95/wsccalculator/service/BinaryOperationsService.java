/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.service;

import com.github.carollo95.wsccalculator.dto.OperateParametersDTO;

import java.math.BigDecimal;

/**
 * Service layer faro the binary operations
 */
public interface BinaryOperationsService {

    /**
     * Operates a binary operation for the given parameters
     * @param operateParameters the parameters to operate on
     * @return the result of the operation
     */
    BigDecimal operateBinary(final OperateParametersDTO operateParameters);

}
