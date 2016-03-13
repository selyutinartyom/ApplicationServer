package org.demo.server.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * Конфтгурация Web контекста Spring
 *
 * @author Secundus
 * @since 12.03.2016 14:50
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = arrayOf("org.demo.server"))
open class WebConfig() : WebMvcConfigurerAdapter() {
}