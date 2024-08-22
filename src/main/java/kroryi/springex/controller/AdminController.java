package kroryi.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("content", "dashboard");
        return "admin/index";
    }

    @GetMapping("/buttons")
    public String buttons(Model model) {
        model.addAttribute("content", "buttons");
        return "admin/index";
    }

    @GetMapping("/member")
    public String member(Model model) {
        return "home.page";
    }

    @GetMapping("/memberlist")
    public String memberlist(Model model) {
        return "memberlist.page";
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
