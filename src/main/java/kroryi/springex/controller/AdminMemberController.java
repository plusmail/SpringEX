package kroryi.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/admin")
public class AdminMemberController {


    @GetMapping("/login")
    public String login(Model model) {


        return "admin/login/login";
    }

    @PostMapping("/login")
    public String login(Model model, String mid, String mpw) {

        log.info("login: {}, {}", mid , mpw);

        return "redirect:/admin/index";
    }

}
