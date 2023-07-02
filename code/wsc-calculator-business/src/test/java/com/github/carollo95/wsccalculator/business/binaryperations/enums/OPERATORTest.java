/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryperations.enums;

import com.github.carollo95.wsccalculator.business.binaryoperations.enums.OPERATOR;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OPERATORTest {

    @Nested
    class FromValue {
        @Test
        void when_null_then_UNDEFINED() {
            final OPERATOR actual = OPERATOR.fromValue(null);
            assertEquals(OPERATOR.UNDEFINED, actual);
        }

        @Test
        void when_existingValue_then_TheCorrespondingValue() {
            final OPERATOR actual = OPERATOR.fromValue("sum");
            assertEquals(OPERATOR.SUM, actual);
        }

        @Test
        void when_nonExistingValue_then_UNDEFINED() {
            final OPERATOR actual = OPERATOR.fromValue("iDontExist");
            assertEquals(OPERATOR.UNDEFINED, actual);
        }
    }

}