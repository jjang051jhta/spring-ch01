package com.jjang051.ch01.controller;

import com.jjang051.ch01.dto.Member;
import com.jjang051.ch01.service.TestService;
import jakarta.servlet.annotation.WebServlet;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class TestController {

    //생성자 주입방식
    private final TestService testService;
//    public TestController(TestService testService) {
//        this.testService = testService;
//    }

    //test에 많이 씀
//    @Autowired
//    TestService testService;
    @GetMapping("/aa")
    //@ResponseBody
    public String aa() {
        testService.test();
        //forward /WEB-INF/member/signin.jsp
        //"templates/" + aa + ".html"
        // message converter
        // view Resolver
        return "aa";
    }

    //@GetMapping("/member")
    @ResponseBody
    public List<Member> responseMember() {
        List<Member> members = new ArrayList<>();
        Member member = new Member();
        member.setIdx(1);
        member.setUserId("jjang051");
        member.setUserName("장성호");
        member.setUserPw("1234");

        Member member02 = new Member();
        member.setIdx(1);
        member.setUserId("jjang051");
        member.setUserName("장성호");
        member.setUserPw("1234");

        members.add(member);
        members.add(member02);
        return members;
    }

}
