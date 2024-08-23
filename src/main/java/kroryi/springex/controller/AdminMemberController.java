package kroryi.springex.controller;

import kroryi.springex.dto.MemberDTO;
import kroryi.springex.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Log4j2
@RequestMapping("/admin")
public class AdminMemberController {

    @Autowired
    private MemberService service;

    @GetMapping("/login")
    public String login(Model model) {


        return "admin/login/login";
    }

    @PostMapping("/login")
    public String login(@Valid MemberDTO dto) {
        log.info("login: {}, {}", dto.getMid() , dto.getMpw());

        MemberDTO getOneDto = service.getOne(dto.getMid());
        if(getOneDto == null) {
            return "redirect:/admin/login";
        }else {
            if(getOneDto.getMpw().equals(dto.getMpw())) {
                return "redirect:/admin";
            }else{
                return "redirect:/admin/login";
            }
        }
    }

    @GetMapping("/memberlist")
    public String memberlist(Model model) {



        model.addAttribute("test","testetstesetse");
        return "admin.memberlist.page";
    }

    @GetMapping("/memberregister")
    public String memberregister(Model model) {
        return "admin.memberregister.page";
    }

    @GetMapping("/memberupdate")
    public String memberupdate(Model model) {
        return "admin.memberupdate.page";
    }

    @GetMapping("/memberview")
    public String memberview(Model model) {
        return "admin.memberview.page";
    }

}
