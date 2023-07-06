/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.api.binaryoperations.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

/**
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public class OperatorDTO {

    private String name;
}
