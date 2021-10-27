package com.tutorial.evips;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {

    @RequestMapping("/form")
    public String showForm() {
        return "form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "home";
    }
}
