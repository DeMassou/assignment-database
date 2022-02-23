package com.example.assignmentdatabase.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String view(
            Model model,
            @RequestParam(value = "name", required = false) String name) {
        model.addAttribute("greeting", name == null ? "world" : name);
        return "home";
    }
}
