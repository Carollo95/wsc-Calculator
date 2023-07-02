/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.controller;

import com.github.carollo95.wsccalculator.binaryoperations.dto.OperateParametersDTO;
import com.github.carollo95.wsccalculator.mapper.OperateParametersRestMapper;
import com.github.carollo95.wsccalculator.restdto.OperateParametersRestDTO;
import com.github.carollo95.wsccalculator.binaryoperations.service.BinaryOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Controller for the BinaryApi specification
 */
@RestController
public class BinaryApiImpl implements com.github.carollo95.wsccalculator.controller.BinaryApi {

    @Autowired
    private OperateParametersRestMapper operateParametersMapper;

    @Autowired
    private BinaryOperationsService binaryOperationsService;


    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<BigDecimal> operateBinary(final OperateParametersRestDTO operateParametersRestDTO) {
        final OperateParametersDTO operateParametersDTO = this.operateParametersMapper.restDtoToDTO(operateParametersRestDTO);
        final BigDecimal serviceResponse = this.binaryOperationsService.operateBinary(operateParametersDTO);
        return ResponseEntity.ok(serviceResponse);
    }
}
