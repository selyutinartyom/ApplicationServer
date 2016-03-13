package org.demo.server.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Контроллер для напоминаний
 *
 * @author Secundus
 * @since 12.03.2016 13:08
 */
@Controller
@RequestMapping("/reminder")
open class ReminderController {

    @RequestMapping(value = "/get", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun getReminder(model: ModelMap): String {
        return "My reminder"
    }
}