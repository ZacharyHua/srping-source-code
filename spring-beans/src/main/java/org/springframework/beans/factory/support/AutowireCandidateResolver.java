/*
 * Copyright 2002-2018 the original author or authors.
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

package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.lang.Nullable;

/**
 * Strategy interface for determining whether a specific bean definition
 * qualifies as an autowire candidate for a specific dependency.
 *
 * 用于确定特定bean定义是否有资格作为特定依赖关系的自动线候选的策略接口。
 *
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @since 2.5
 */

// Autowire候选解析器    候选的策略接口
public interface AutowireCandidateResolver {

	/**
	 * Determine whether the given bean definition qualifies as an
	 * autowire candidate for the given dependency.
	 * 确定给定的bean定义是否有资格作为给定依赖项的autowire候选。
	 *
	 * <p>The default implementation checks
	 * // 默认实现检查
	 * {@link org.springframework.beans.factory.config.BeanDefinition#isAutowireCandidate()}.
	 * @param bdHolder the bean definition including bean name and aliases
	 *                    bean定义包括bean名称和别名
	 * @param descriptor the descriptor for the target method parameter or field
	 *                    目标方法参数或字段的描述符
	 * @return whether the bean definition qualifies as autowire candidate
	 * 					bean定义是否有资格作为autowire候选者
	 * @see org.springframework.beans.factory.config.BeanDefinition#isAutowireCandidate()
	 */
	default boolean isAutowireCandidate(BeanDefinitionHolder bdHolder, DependencyDescriptor descriptor) {
		return bdHolder.getBeanDefinition().isAutowireCandidate();
	}

	/**
	 * Determine whether the given descriptor is effectively required.
	 * <p>The default implementation checks {@link DependencyDescriptor#isRequired()}.
	 * @param descriptor the descriptor for the target method parameter or field
	 * @return whether the descriptor is marked as required or possibly indicating
	 * non-required status some other way (e.g. through a parameter annotation)
	 * @since 5.0
	 * @see DependencyDescriptor#isRequired()
	 */
	// 确定是否有效地要求给定描述符。
	default boolean isRequired(DependencyDescriptor descriptor) {
		return descriptor.isRequired();
	}

	/**
	 * Determine whether the given descriptor declares a qualifier beyond the type
	 * (typically - but not necessarily - a specific kind of annotation).
	 * <p>The default implementation returns {@code false}.
	 * @param descriptor the descriptor for the target method parameter or field
	 * @return whether the descriptor declares a qualifier, narrowing the candidate
	 * status beyond the type match
	 * @since 5.1
	 * @see org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver#hasQualifier
	 */
	// 确定给定描述符是否声明超出类型的限定符
	default boolean hasQualifier(DependencyDescriptor descriptor) {
		return false;
	}

	/**
	 * Determine whether a default value is suggested for the given dependency.
	 * <p>The default implementation simply returns {@code null}.
	 * @param descriptor the descriptor for the target method parameter or field
	 * @return the value suggested (typically an expression String),
	 * or {@code null} if none found
	 * @since 3.0
	 */
	// 确定是否为给定的依赖项建议了默认值。
	@Nullable
	default Object getSuggestedValue(DependencyDescriptor descriptor) {
		return null;
	}

	/**
	 * Build a proxy for lazy resolution of the actual dependency target,
	 * if demanded by the injection point.
	 * <p>The default implementation simply returns {@code null}.
	 * @param descriptor the descriptor for the target method parameter or field
	 * @param beanName the name of the bean that contains the injection point
	 * @return the lazy resolution proxy for the actual dependency target,
	 * or {@code null} if straight resolution is to be performed
	 * @since 4.0
	 */
	// 如果注入点需要，为实际依赖关系目标的延迟解析构建代理。
	@Nullable
	default Object getLazyResolutionProxyIfNecessary(DependencyDescriptor descriptor, @Nullable String beanName) {
		return null;
	}

}
