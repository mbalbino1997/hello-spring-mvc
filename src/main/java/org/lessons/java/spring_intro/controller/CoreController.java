package org.lessons.java.spring_intro.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;



@Controller
@RequestMapping("/")

public class CoreController {
    @GetMapping("/welcome")
    public String welcome(@RequestParam(name="name") String name, Model model) {
        model.addAttribute("email","rmassimo.balbino@gmail.com");
        model.addAttribute("currentDate",LocalDateTime.now());
        model.addAttribute("name",name);
        

        
        
        return "greetings";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("info", "Questa è una pagina di informazioni.");
        return "about"; // about.html
    }
    
}
