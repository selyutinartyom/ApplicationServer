package org.demo.server.service

import org.demo.server.entity.Remind

/**
 * Service for reminders
 *
 * @author Secundus
 * @since 05.04.2016 22:55
 */
interface ReminderService {
    fun getAll(): List<Remind>
    fun getById(id: Long): Remind
    fun save(remind: Remind): Remind
    fun remove(id: Long)
}