package org.demo.server.config

import com.fasterxml.jackson.core.Version
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.demo.server.utils.LocalDateTimeDeserializer
import org.demo.server.utils.LocalDateTimeSerializer
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import java.time.LocalDateTime

/**
 * Spring Web context configuration
 *
 * @author Secundus
 * @since 12.03.2016 14:50
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = arrayOf("org.demo.server"))
open class WebConfig() : WebMvcConfigurerAdapter() {

    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>?) {
        val simpleModule = SimpleModule("CustomSimpleModule", Version(1, 0, 0, "SNAPSHOT", "org.demo.server", null))
        simpleModule.addSerializer(LocalDateTime::class.java, LocalDateTimeSerializer());
        simpleModule.addDeserializer(LocalDateTime::class.java, LocalDateTimeDeserializer());

        val objectMapper = ObjectMapper()
        objectMapper.registerModule(JavaTimeModule())
        objectMapper.registerModule(simpleModule)

        val converter = MappingJackson2HttpMessageConverter()
        converter.objectMapper = objectMapper
        converter.supportedMediaTypes = listOf(MediaType.APPLICATION_JSON)

        converters?.add(converter)
    }
}