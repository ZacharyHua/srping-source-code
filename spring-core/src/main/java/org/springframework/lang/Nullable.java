/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.lang;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.When;

/**
 * A common Spring annotation to declare that annotated elements can be {@code null} under
 * some circumstance.
 * 一个常见的Spring注释，用于声明在某些情况下带注释的元素可以是{@code null}。
 *
 * <p>Leverages JSR-305 meta-annotations to indicate nullability in Java to common
 * tools with JSR-305 support and used by Kotlin to infer nullability of Spring API.
 * <p>利用JSR-305元注释来指示Java中的可空性，以及JSR-305支持的常用工具，并由Kotlin用于推断Spring API的可空性。
 *
 * <p>Should be used at parameter, return value, and field level. Methods override should
 * repeat parent {@code @Nullable} annotations unless they behave differently.
 * <p>应该在参数，返回值和字段级别使用。 方法覆盖应重复父{@code @Nullable}注释，除非它们的行为不同。
 *
 * <p>Can be used in association with {@code @NonNullApi} or {@code @NonNullFields} to
 * override the default non-nullable semantic to nullable.
 * 可以与{@code @NonNullApi}或{@code @NonNullFields}结合使用，以将默认的非可空语义覆盖为可为空。
 *
 * @author Sebastien Deleuze
 * @author Juergen Hoeller
 * @since 5.0
 * @see NonNullApi
 * @see NonNullFields
 * @see NonNull
 */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Nonnull(when = When.MAYBE)
@TypeQualifierNickname
public @interface Nullable {
}
