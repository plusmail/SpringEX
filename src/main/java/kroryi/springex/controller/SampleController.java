package kroryi.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDate;

@Log4j2
@Controller
public class SampleController {

    @GetMapping("/hello")
    public void hello(){
        log.info("hello.....................");
    }

    @GetMapping("/ex2")
    public void ex2(String name, double age){
        log.info("ex2.....................");
        log.info("이름: {}", name);
        log.info("나이: {}", age);
    }

    @GetMapping("/ex3")
    public void ex3(@RequestParam(name="name", defaultValue = "최영민") String name,
                    @RequestParam(name="age", defaultValue = "23") int age)
    {
        log.info("ex3.....................");
        log.info("이름: {}", name);
        log.info("나이: {}", age);
    }


    @GetMapping("/ex4")
    public void ex4(LocalDate dueDate){
        log.info("ex4.....................");
        log.info("dueDate: {}", dueDate);
    }

    @GetMapping("/ex5")
    public void ex5(Model model){
        log.info("ex5.....................");
        //model을 jsp로 던진다.
        model.addAttribute("message", "데이터를 던진다 받아라..");
    }

}
