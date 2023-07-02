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

package com.github.carollo95.wsccalculator.business.binaryoperations.beans;

import com.github.carollo95.wsccalculator.business.binaryoperations.enums.OPERATOR;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;


/**
 * Parameters for the performance of binary operations
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public class OperateParametersBean {

    private OPERATOR operator;

    @Builder.Default
    private List<BigDecimal> operands = new ArrayList<>();
}
