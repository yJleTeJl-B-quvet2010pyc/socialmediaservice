package net.tajlanta.socialmediaservice.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String salam(Model model) {
        model.addAttribute("name", "Саламчик");
        return "salam";
    }

}
