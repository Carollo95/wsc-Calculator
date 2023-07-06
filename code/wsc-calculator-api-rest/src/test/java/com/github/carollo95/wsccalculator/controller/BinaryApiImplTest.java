/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.controller;

import com.github.carollo95.wsccalculator.api.binaryoperations.dto.OperateParametersDTO;
import com.github.carollo95.wsccalculator.api.binaryoperations.dto.OperateResultDTO;
import com.github.carollo95.wsccalculator.api.binaryoperations.service.BinaryOperationsService;
import com.github.carollo95.wsccalculator.mapper.OperateParametersRestMapper;
import com.github.carollo95.wsccalculator.mapper.OperateResultRestMapper;
import com.github.carollo95.wsccalculator.restdto.OperateParametersRestDTO;
import com.github.carollo95.wsccalculator.restdto.OperateResultRestDTO;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BinaryApiImplTest {

    @InjectMocks
    private BinaryApiImpl target;

    @Mock
    private OperateParametersRestMapper operateParametersMapper;
    @Mock
    private OperateResultRestMapper operateResultMapper;
    @Mock
    private BinaryOperationsService binaryOperationsService;

    @Nested
    class OperateBinary {
        @Test
        void when_Called_then_DelegatesOnTheService() {
            final OperateParametersRestDTO params = new OperateParametersRestDTO(null, null);

            final OperateParametersDTO serviceParams = new OperateParametersDTO();
            when(operateParametersMapper.restDtoToDTO(params)).thenReturn(serviceParams);
            final OperateResultDTO serviceResponse = new OperateResultDTO();
            when(binaryOperationsService.operateBinary(serviceParams)).thenReturn(serviceResponse);
            OperateResultRestDTO result = new OperateResultRestDTO(null);
            when(operateResultMapper.dtoToRestDTO(serviceResponse)).thenReturn(result);

            final ResponseEntity<OperateResultRestDTO> expected = ResponseEntity.ok(result);
            final ResponseEntity<OperateResultRestDTO> actual = target.operateBinary(params);

            assertEquals(expected, actual);
        }
    }

}