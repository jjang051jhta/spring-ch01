package com.jjang051.ch01.controller;

import com.jjang051.ch01.dto.Member;
import com.jjang051.ch01.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public String list(Model model) {
        ArrayList<Member> members = (ArrayList<Member>) memberService.findAllMember();
        model.addAttribute("members", members);
        return "member/members";
    }

    @GetMapping("/{id}")
    public String info(@PathVariable int id,Model model) {

        Member infoMember = memberService.infoMember(id).get();
        model.addAttribute("infoMember",infoMember);
        model.addAttribute("title","회원정보 페이지");
        model.addAttribute("status",true);
        return "member/info";
    }
    //@GetMapping("/signin")
    public String signin(Model model) {
        model.addAttribute("member",new Member());
        return "member/signin02";
    }


    @GetMapping("/signin")
    public String signin03(Model model) {
        model.addAttribute("member",new Member());
        return "member/signin03";
    }

    //@PostMapping("/signin")
    public String signinProcess03(@ModelAttribute("mmm") Member paramMember,
                                  BindingResult bindingResult,
                                  Model model) {
        if(!StringUtils.hasText(paramMember.getUserId())) {
            bindingResult.addError(new FieldError("paramMember","userId",
                    "id는 필수 입력사항입니다."));
            log.info("userid==={}",paramMember.getUserId());
        }
        if(!StringUtils.hasText(paramMember.getUserName())) {
            bindingResult.addError(new FieldError("paramMember","userName",
                    "회원이름은 필수 입력사항입니다."));
            log.info("userName==={}",paramMember.getUserName());
        }
        if(!StringUtils.hasText(paramMember.getUserPw())) {
            bindingResult.addError(new FieldError("paramMember","userPw",
                    "password는 필수 입력사항입니다."));
            log.info("userPw==={}",paramMember.getUserPw());
        }
        if(bindingResult.hasErrors()) {

            //model.addAttribute("paramMember",new Member("jjang051","장성호","1234"));
            return "member/signin02";
        }
        Member saveMember = memberService.saveMember(paramMember);
        log.info("saveMember={}",saveMember.toString());
        return "redirect:/member";
    }

    @PostMapping("/signin")
    public String signinProcess04(@Valid @ModelAttribute Member paramMember,
                                  BindingResult bindingResult,
                                  Model model) {

        if(bindingResult.hasErrors()) {

            //model.addAttribute("paramMember",new Member("jjang051","장성호","1234"));
            return "member/signin03";
        }
        Member saveMember = memberService.saveMember(paramMember);
        log.info("saveMember={}",saveMember.toString());
        return "redirect:/member";
    }
}
