package kroryi.springex.controller;


import kroryi.springex.dto.PageRequestDTO;
import kroryi.springex.dto.PageResponseDTO;
import kroryi.springex.dto.TodoDTO;
import kroryi.springex.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Log4j2
@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public void register(Model model){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String today = LocalDate.now().format(formatter);
        log.info(today);
        model.addAttribute("today", today);
        log.info("todo -> register controller");
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String register(@Valid TodoDTO todoDTO,
                           BindingResult bindingResult,
                           RedirectAttributes ra){
        log.info("POST todo -> register controller");
        //현재 문제 발생해서 에러처리 않됨.
        if(bindingResult.hasErrors()){
            log.info("binding errors");
            ra.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }

        log.info(todoDTO);

        todoService.register(todoDTO);

        return "redirect:/todo/list";
    }

//    @RequestMapping("/list")
//    public String list(Model model){
//
//        model.addAttribute("dtoList", todoService.getAll());
//
//        return "todo/list";
//    }

    @RequestMapping("/list")
    public String list(@Valid PageRequestDTO pageRequestDTO,
                       BindingResult br,
                       Model model){
        log.info("pageRequestDTO -> list controller");

        log.info("List-pagereqeustDTO->{}", pageRequestDTO.getLink());

        if(br.hasErrors()){
            pageRequestDTO = PageRequestDTO.builder().build();
        }

        model.addAttribute("responeDTO", todoService.getList(pageRequestDTO));
        model.addAttribute("pageRequestDTO", pageRequestDTO);

        return "todo/list";
    }

    @RequestMapping({"/read","modify"})
    public void read(Long tno, PageRequestDTO pageRequestDTO, Model model){
        TodoDTO todoDTO = todoService.getOne(tno);
        model.addAttribute("dto", todoDTO);
        model.addAttribute("pageRequestDTO", pageRequestDTO);

    }

    @RequestMapping(value="/modify", method = RequestMethod.POST)
    public String modify(PageRequestDTO pageRequestDTO, @Valid TodoDTO todoDTO,
                         BindingResult br,
                         RedirectAttributes ra){
        //책하고 다른 부분
        ra.addAttribute("page",pageRequestDTO.getPage());
        ra.addAttribute("size", pageRequestDTO.getSize());

        if(br.hasErrors()){
            log.info("binding errors");
            ra.addFlashAttribute("errors", br.getAllErrors());
            ra.addAttribute("tno", todoDTO.getTno());
            return "redirect:/todo/modify";
        }
        log.info(todoDTO);
        todoService .modify(todoDTO);

        return "redirect:/todo/list";

    }





    @RequestMapping(value="/remove", method = RequestMethod.POST)
    public String remove(Long tno, PageRequestDTO pageRequestDTO,  RedirectAttributes ra){
        log.info("POST todo -> remove controller");
        log.info("tno: {}", tno);

        todoService.remove(tno);
        ra.addAttribute("page",pageRequestDTO.getPage());
        ra.addAttribute("size", pageRequestDTO.getSize());
        return "redirect:/todo/list";
//        return "redirect:/todo/list?${pageRequestDTO.link}";
    }



//    @RequestMapping({"/read","modify"})
//    public String readOrModify(Long tno, Model model, HttpServletRequest req){
//        TodoDTO todoDTO = todoService.getOne(tno);
//        model.addAttribute("dto", todoDTO);
//        String reqURI = req.getRequestURI();
//        if(reqURI.contains("/modify")){
//            return "/todo/modify";
//        }else{
//            return "/todo/read";
//        }
//    }
//

//    @RequestMapping("/read")
//    public void read(Long tno, Model model){
//        TodoDTO todoDTO = todoService.getOne(tno);
//        model.addAttribute("dto", todoDTO);
//    }
//
//    @RequestMapping("/modify")
//    public void modify(Long tno, Model model){
//        TodoDTO todoDTO = todoService.getOne(tno);
//        model.addAttribute("dto", todoDTO);
//    }


}
