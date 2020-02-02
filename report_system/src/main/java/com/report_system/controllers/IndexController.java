package com.report_system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String showIndex(Model model) {
        String title = "Report system";
        model.addAttribute("title", title);

        return "index";
    }
}
