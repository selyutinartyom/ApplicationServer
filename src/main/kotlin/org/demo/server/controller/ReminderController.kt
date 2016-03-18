package org.demo.server.controller

import org.demo.server.entity.Remind
import org.demo.server.repository.RemindRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import javax.servlet.http.HttpServletResponse

/**
 * Контроллер для напоминаний
 *
 * @author Secundus
 * @since 12.03.2016 13:08
 */
@RestController
@RequestMapping("/reminder")
open class ReminderController @Autowired constructor(val remindRepository : RemindRepository) {

    @RequestMapping(value = "/get", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun getReminder(model: ModelMap): Remind {
//        val list: List<Remind> = remindRepository.findAll()
        return createMockRemind()
    }

    @RequestMapping(value = "/set", method = arrayOf(RequestMethod.POST))
    fun setReminder(response: HttpServletResponse, @RequestBody remind: Remind): Remind {
        return remind
    }

    private fun createMockRemind(): Remind {
        return Remind(1, "My first remind", LocalDateTime.now())
    }
}