/*
 * Copyright (C) 2006 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.elasticsearch.common.inject;

/**
 *
 * 一个模块提供配置信息，通常是接口绑定，将用于创建一个Injector。基于Guice的应用程序最终只由一组 Modules和一些引导代码组成。
    你的Module类可以通过扩展AbstractModule而不是直接实现这个接口来使用更简化的语法 。

    除了通过配置的绑定之外configure(org.elasticsearch.common.inject.Binder)，还将为使用@注释的所有方法创建绑定Provides。在这些方法上使用范围和绑定注释来配置绑定。

 * A module contributes configuration information, typically interface
 * bindings, which will be used to create an {@link Injector}. A Guice-based
 * application is ultimately composed of little more than a set of
 * {@code Module}s and some bootstrapping code.
 * <p>
 * Your Module classes can use a more streamlined syntax by extending
 * {@link AbstractModule} rather than implementing this interface directly.
 * <p>
 * In addition to the bindings configured via {@link #configure}, bindings
 * will be created for all methods annotated with {@literal @}{@link Provides}.
 * Use scope and binding annotations on these methods to configure the
 * bindings.
 */
public interface Module {

    /**
     * 为该模块贡献绑定和其他配置binder。
        不要直接调用此方法来安装子模块。而是使用 Binder.install(Module)，确保provider methods被发现
     * Contributes bindings and other configurations for this module to {@code binder}.
     * <p>
     * <strong>Do not invoke this method directly</strong> to install submodules. Instead use
     * {@link Binder#install(Module)}, which ensures that {@link Provides provider methods} are
     * discovered.
     */
    void configure(Binder binder);
}
