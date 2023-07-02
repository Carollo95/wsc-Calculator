/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.controller;

import com.github.carollo95.wsccalculator.restdto.OperateParametersRestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Controller for the BinaryApi specification
 */
@RestController
public class BinaryApiImpl implements BinaryApi {
    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<BigDecimal> operateBinary(final OperateParametersRestDTO operateParametersRestDTO) {
        return BinaryApi.super.operateBinary(operateParametersRestDTO);
    }
}
