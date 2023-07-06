/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.mapper;

import com.github.carollo95.wsccalculator.api.binaryoperations.dto.OperatorDTO;
import com.github.carollo95.wsccalculator.restdto.OperatorRestDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper for the rest layer for the Operator entity
 */
@Mapper(componentModel = "spring")
public interface OperatorRestMapper {
    List<OperatorRestDTO> dtoListToRestDtoList(List<OperatorDTO> serviceResponse);
}
