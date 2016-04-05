package org.demo.server.controller

import org.demo.server.entity.Remind
import org.demo.server.service.ReminderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Controller for reminders
 *
 * @author Secundus
 * @since 12.03.2016 13:08
 */
@RestController
@RequestMapping("/reminders")
open class ReminderController @Autowired constructor(
        val service: ReminderService) {

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun getAllReminders(): List<Remind> {
        return service.getAll()
    }

    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun getReminder(@PathVariable("id") remindId: Long): Remind {
        return service.getById(remindId)
    }

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun saveReminder(@RequestBody remind: Remind): Remind {
        return service.save(remind)
    }

    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.DELETE))
    fun delete(@PathVariable id: Long) {
        service.remove(id)
    }
}