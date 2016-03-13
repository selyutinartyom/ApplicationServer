package org.demo.server.entity

import org.demo.server.utils.LocalDateTimeAttributeConverter
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime
import javax.persistence.*

/**
 * Сущность Напоминание.
 *
 * @author Secundus
 * @since 13.03.2016 13:52
 */
@Entity
@Table(name = "remind")
data class Remind(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @GenericGenerator(name = "increment", strategy = "increment")
        var id: Long = 0,

        @Column(name = "title", nullable = false, length = 50)
        var title: String = "",

        // @see http://www.thoughts-on-java.org/persist-localdate-localdatetime-jpa/
        @Column(name = "remind_date", nullable = false)
        @Convert(converter = LocalDateTimeAttributeConverter::class)
        var remindDate: LocalDateTime = LocalDateTime.now()
)