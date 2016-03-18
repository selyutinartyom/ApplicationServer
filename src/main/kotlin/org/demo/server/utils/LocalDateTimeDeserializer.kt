package org.demo.server.utils

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

/**
 * Provide custom class to Jackson SimpleModule Deserializer
 *
 * @author Secundus
 * @since 16.03.2016 21:40
 */
open class LocalDateTimeDeserializer : JsonDeserializer<LocalDateTime>() {
    override fun deserialize(p0: JsonParser?, p1: DeserializationContext?): LocalDateTime? {
        val inDate: Date? = if (p0?.longValue == null) null else Date(p0?.longValue as Long)
        return LocalDateTime.ofInstant(inDate?.toInstant(), ZoneId.systemDefault())
    }
}