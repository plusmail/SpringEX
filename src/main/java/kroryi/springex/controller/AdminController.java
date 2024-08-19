package kroryi.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/")
    public String home() {

        return "admin/home";
    }

    @GetMapping("/buttons")
    public String buttons() {
        return "admin/buttons";
    }

    @GetMapping("/cards")
    public String cards() {
        return "admin/cards";
    }


//    @GetMapping("/home")
//    public void home(){
//
//    }

}
