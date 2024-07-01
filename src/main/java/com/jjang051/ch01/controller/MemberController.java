package com.jjang051.ch01.controller;

import com.jjang051.ch01.dto.Member;
import com.jjang051.ch01.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signin")
    public String signin() {
        //"/templates/"+ member/signin+".html"
        return "member/signin";
    }

    //@PostMapping("/signin")
    public String signinProcess(@RequestParam String userId,
                                @RequestParam String userName,
                                @RequestParam String userPw) {
        Member paramMember = new Member();
        paramMember.setUserId(userId);
        paramMember.setUserName(userName);
        paramMember.setUserPw(userPw);
        Member saveMember = memberService.saveMember(paramMember);
        log.info("saveMember={}",saveMember.toString());
        return "redirect:/";
    }
    @PostMapping("/signin")
    public String signinProcess02(@ModelAttribute Member paramMember) {

        //Member paramMember = new Member();
        //paramMember.setUserId(userId);
        //paramMember.setUserName(userName);
        //paramMember.setUserPw(userPw);
        Member saveMember = memberService.saveMember(paramMember);
        log.info("saveMember={}",saveMember.toString());
        return "redirect:/";
    }
}
