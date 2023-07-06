/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryperations.enums;

import com.github.carollo95.wsccalculator.business.binaryoperations.enums.OPERATOR;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OPERATORTest {

    @Nested
    class FromName {
        @Test
        void when_null_then_UNDEFINED() {
            final OPERATOR actual = OPERATOR.fromName(null);
            assertEquals(OPERATOR.UNDEFINED, actual);
        }

        @Test
        void when_sum_then_SUM() {
            final OPERATOR actual = OPERATOR.fromName("sum");
            assertEquals(OPERATOR.SUM, actual);
        }

        @Test
        void when_subtract_then_TheCorrespondingValue() {
            final OPERATOR actual = OPERATOR.fromName("subtract");
            assertEquals(OPERATOR.SUBTRACT, actual);
        }

        @Test
        void when_nonExistingValue_then_UNDEFINED() {
            final OPERATOR actual = OPERATOR.fromName("iDontExist");
            assertEquals(OPERATOR.UNDEFINED, actual);
        }
    }

    @Nested
    class GetValidOperators {
        @Test
        void when_called_then_TheListOfValidOperators() {
            final List<OPERATOR> actual = OPERATOR.getValidOperators();
            final List<OPERATOR> expected = List.of(OPERATOR.SUM, OPERATOR.SUBTRACT);
            assertEquals(expected, actual);

        }
    }

}