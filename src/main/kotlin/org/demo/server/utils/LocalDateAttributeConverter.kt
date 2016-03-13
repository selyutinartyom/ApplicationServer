package org.demo.server.utils

import java.sql.Date
import java.time.LocalDate
import javax.persistence.AttributeConverter
import javax.persistence.Converter

/**
 * Конвертер java.time.LocalDate в/из java.sql.Date

 * @author Secundus
 * *
 * @since 13.03.2016 18:44
 */
@Converter(autoApply = true)
open class LocalDateAttributeConverter : AttributeConverter<LocalDate, Date> {

    override fun convertToDatabaseColumn(attribute: LocalDate?): Date? = if (attribute == null) null else Date.valueOf(attribute)

    override fun convertToEntityAttribute(dbData: Date?): LocalDate? = dbData?.toLocalDate()
}
