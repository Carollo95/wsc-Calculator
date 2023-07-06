/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.api.binaryoperations.mapper;

import com.github.carollo95.wsccalculator.api.binaryoperations.dto.OperatorDTO;
import com.github.carollo95.wsccalculator.business.binaryoperations.enums.OPERATOR;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper for the operator entity
 */
@Mapper(componentModel = "spring")
public interface OperatorMapper {

    List<OperatorDTO> enumListToDto(List<OPERATOR> enumList);

    OperatorDTO enumToDTO(OPERATOR enumVal);
}
