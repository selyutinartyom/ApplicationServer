package org.demo.server.utils

import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.AttributeConverter
import javax.persistence.Converter

/**
 * Converter java.time.LocalDateTime to/from java.sql.Timestamp
 *
 * @author Secundus
 * @since 13.03.2016 18:26
 */
@Converter(autoApply = true)
open class LocalDateTimeAttributeConverter : AttributeConverter<LocalDateTime, Timestamp> {

    override fun convertToDatabaseColumn(attribute: LocalDateTime?): Timestamp? = if (attribute == null) null else Timestamp.valueOf(attribute)

    override fun convertToEntityAttribute(dbData: Timestamp?): LocalDateTime? = dbData?.toLocalDateTime()
}
