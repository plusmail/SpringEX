package kroryi.springex.controller;

import kroryi.springex.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/ex6form")
    public void ex6form(){
        log.info("ex6.....................");
    }
    @PostMapping("/ex6con")
    public void ex6con(@ModelAttribute("dto") TodoDTO todoDTO, Model model){
        log.info("ex6 controller.....................");
        log.info(todoDTO.toString());
    }

    @GetMapping("/ex7")
    public String ex7(RedirectAttributes ra){

        ra.addAttribute("name", "강감찬");
        ra.addFlashAttribute("result", "성공했다.");
        //jsp가 없어도 됩니다.
        return "redirect:/ex8";
    }

    @GetMapping("/ex8")
    public void ex8(String name, Model model){
        //name Query String 으로 전달된 값.
        // model은 jsp에서 사용할 데이터를 name 이름으로 등록해서 전달
        // model 초기에는 빈 값
        model.addAttribute("name", name);
        log.info("ex7......................{}", name);

    }



    @GetMapping("/ex9")
    public void ex9(String name, int num){
        log.info("name------>{}", name);
        log.info("num------>{}", num);
    }

}
