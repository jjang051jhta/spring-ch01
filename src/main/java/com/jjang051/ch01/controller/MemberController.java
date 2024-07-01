package com.jjang051.ch01.controller;

import com.jjang051.ch01.dto.Member;
import com.jjang051.ch01.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        return "member/info";
    }
    @GetMapping("/signin")
    public String signin() {
        //"/templates/"+ member/signin+".html"
        return "member/signin";
    }

    //@PostMapping("/signin")
    public String signinProcess(@RequestParam String userId,
                                @RequestParam String userName,
                                @RequestParam String userPw) {
//        Member paramMember = new Member();
//        paramMember.setUserId(userId);
//        paramMember.setUserName(userName);
//        paramMember.setUserPw(userPw);
        Member paramMember = Member.builder()
                .userId(userId)
                .userName(userName)
                .userPw(userPw)
                .build();
        Member saveMember = memberService.saveMember(paramMember);
        log.info("saveMember={}",saveMember.toString());
        return "redirect:/member";
    }
    @PostMapping("/signin")
    public String signinProcess02(@ModelAttribute Member paramMember) {

        //Member paramMember = new Member();
        //paramMember.setUserId(userId);
        //paramMember.setUserName(userName);
        //paramMember.setUserPw(userPw);
        Member saveMember = memberService.saveMember(paramMember);
        log.info("saveMember={}",saveMember.toString());
        return "redirect:/member";
    }
}
