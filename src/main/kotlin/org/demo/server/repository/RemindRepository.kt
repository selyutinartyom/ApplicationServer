package org.demo.server.repository

import org.demo.server.entity.Remind
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Репозиторий Напоминание.
 *
 * @author Secundus
 * @since 14.03.2016 0:32
 */
open interface RemindRepository : JpaRepository<Remind, Long> {
}