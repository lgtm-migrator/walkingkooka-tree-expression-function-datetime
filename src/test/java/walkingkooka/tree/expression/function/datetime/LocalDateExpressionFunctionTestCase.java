
/*
 * Copyright 2019 Miroslav Pokorny (github.com/mP1)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package walkingkooka.tree.expression.function.datetime;

import walkingkooka.tree.expression.ExpressionNumber;
import walkingkooka.tree.expression.ExpressionNumberKind;
import walkingkooka.tree.expression.function.ExpressionFunctionContext;
import walkingkooka.tree.expression.function.FakeExpressionFunctionContext;

import java.time.LocalDate;

public abstract class LocalDateExpressionFunctionTestCase<F extends LocalDateExpressionFunction<ExpressionFunctionContext>> extends ExpressionFunctionTestCase<F, LocalDate> {

    final static ExpressionNumberKind KIND = ExpressionNumberKind.DEFAULT;

    final static int TWO_DIGIT_YEAR = 1900;

    LocalDateExpressionFunctionTestCase() {
        super();
    }

    @Override
    public final ExpressionFunctionContext createContext() {
        return new FakeExpressionFunctionContext(){
            @Override
            public ExpressionNumberKind expressionNumberKind() {
                return KIND;
            }

            @Override
            public int twoToFourDigitYear(final int year) {
                return TWO_DIGIT_YEAR + year;
            }
        };
    }

    @Override
    public final String typeNamePrefix() {
        return LocalDateExpressionFunction.class.getSimpleName();
    }
}
