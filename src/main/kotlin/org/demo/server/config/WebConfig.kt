package org.demo.server.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
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

    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>?) {
        val converter = MappingJackson2HttpMessageConverter()
        converter.objectMapper = ObjectMapper()
        converter.supportedMediaTypes = listOf(MediaType.APPLICATION_JSON)

        converters?.add(converter)
    }
}