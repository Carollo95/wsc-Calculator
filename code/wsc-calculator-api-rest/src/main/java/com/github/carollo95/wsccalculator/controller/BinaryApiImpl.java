/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.controller;

import com.github.carollo95.wsccalculator.api.binaryoperations.dto.OperateParametersDTO;
import com.github.carollo95.wsccalculator.api.binaryoperations.dto.OperateResultDTO;
import com.github.carollo95.wsccalculator.mapper.OperateParametersRestMapper;
import com.github.carollo95.wsccalculator.mapper.OperateResultRestMapper;
import com.github.carollo95.wsccalculator.restdto.OperateParametersRestDTO;
import com.github.carollo95.wsccalculator.restdto.OperateResultRestDTO;
import com.github.carollo95.wsccalculator.api.binaryoperations.service.BinaryOperationsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the BinaryApi specification
 */
@RestController
@Validated
public class BinaryApiImpl implements com.github.carollo95.wsccalculator.controller.BinaryApi {

    @Autowired
    private BinaryOperationsService binaryOperationsService;

    @Autowired
    private OperateParametersRestMapper operateParametersMapper;
    @Autowired
    private OperateResultRestMapper operateResultMapper;


    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<OperateResultRestDTO> operateBinary(final @Valid OperateParametersRestDTO operateParametersRestDTO) {
        final OperateParametersDTO operateParametersDTO = this.operateParametersMapper.restDtoToDTO(operateParametersRestDTO);
        final OperateResultDTO serviceResponse = this.binaryOperationsService.operateBinary(operateParametersDTO);
        final OperateResultRestDTO response = this.operateResultMapper.dtoToRestDTO(serviceResponse);
        return ResponseEntity.ok(response);
    }
}
