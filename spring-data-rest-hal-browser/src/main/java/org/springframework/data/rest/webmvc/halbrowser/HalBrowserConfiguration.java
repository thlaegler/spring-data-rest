/*
 * Copyright 2019-2020 the original author or authors.
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
package org.springframework.data.rest.webmvc.halbrowser;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.StaticResourceProvider;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * {@link StaticResourceProvider} to expose the HAL Browser WebJar content via a static resource route.
 *
 * @author Oliver Drotbohm
 * @since 3.2
 * @soundtrack Tedeschi Trucks Band - Signs, High Times (Signs)
 */
class HalBrowserConfiguration implements StaticResourceProvider {

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.rest.webmvc.config.StaticResourceProvider#customizeResources(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry, org.springframework.data.rest.core.config.RepositoryRestConfiguration)
	 */
	@Override
	public void customizeResources(ResourceHandlerRegistry registry, RepositoryRestConfiguration configuration) {

		String basePath = configuration.getBasePath().toString().concat(HalBrowser.BROWSER);
		String rootLocation = "classpath:META-INF/spring-data-rest/hal-browser/";

		registry.addResourceHandler(basePath.concat("/**")).addResourceLocations(rootLocation);
	}
}
