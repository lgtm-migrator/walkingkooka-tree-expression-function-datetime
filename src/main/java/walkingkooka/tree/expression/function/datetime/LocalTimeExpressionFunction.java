/*
 * Copyright 2020 Miroslav Pokorny (github.com/mP1)
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

import walkingkooka.tree.expression.ExpressionPurityContext;
import walkingkooka.tree.expression.FunctionExpressionName;
import walkingkooka.tree.expression.function.ExpressionFunction;
import walkingkooka.tree.expression.function.ExpressionFunctionContext;
import walkingkooka.tree.expression.function.ExpressionFunctionKind;

import java.time.LocalTime;
import java.util.EnumSet;
import java.util.Set;

abstract class LocalTimeExpressionFunction<C extends ExpressionFunctionContext> implements ExpressionFunction<LocalTime, C> {

    LocalTimeExpressionFunction(final String name) {
        super();
        this.name = FunctionExpressionName.with(name);
    }

    @Override
    public final FunctionExpressionName name() {
        return this.name;
    }

    private final FunctionExpressionName name;

    @Override
    public final Class<LocalTime> returnType() {
        return LocalTime.class;
    }

    @Override
    public final Set<ExpressionFunctionKind> kinds() {
        return KINDS;
    }

    private final Set<ExpressionFunctionKind> KINDS = EnumSet.of(
            ExpressionFunctionKind.REQUIRES_EVALUATED_PARAMETERS,
            ExpressionFunctionKind.RESOLVE_REFERENCES
    );

    @Override
    public final boolean isPure(ExpressionPurityContext expressionPurityContext) {
        return true;
    }

    @Override
    public final String toString() {
        return this.name().toString();
    }
}
