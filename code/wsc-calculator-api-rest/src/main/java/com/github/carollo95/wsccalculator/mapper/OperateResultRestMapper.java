/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.mapper;

import com.github.carollo95.wsccalculator.restdto.OperateResultRestDTO;
import com.github.carollo95.wsccalculator.api.binaryoperations.dto.OperateResultDTO;
import org.mapstruct.Mapper;

/**
 * Rest mapper for the operate result entity
 */
@Mapper(componentModel = "spring")
public interface OperateResultRestMapper {
    OperateResultRestDTO dtoToRestDTO(OperateResultDTO serviceResponse);
}
