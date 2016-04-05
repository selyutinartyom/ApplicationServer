package org.demo.server.service

import org.demo.server.entity.Remind
import org.demo.server.repository.RemindRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Service for reminders implementation
 *
 * @author Secundus
 * @since 05.04.2016 22:59
 */
@Service
class ReminderServiceImpl @Autowired constructor(
        val repository: RemindRepository) : ReminderService {

    override fun getAll(): List<Remind> {
        return repository.findAll()
    }

    override fun getById(id: Long): Remind {
        return repository.findOne(id)
    }

    override fun save(remind: Remind): Remind {
        return repository.saveAndFlush(remind)
    }

    override fun remove(id: Long) {
        repository.delete(id)
    }
}