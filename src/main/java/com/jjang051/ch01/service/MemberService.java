package com.jjang051.ch01.service;


import com.jjang051.ch01.dto.Member;
import com.jjang051.ch01.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    // repository
    private final MemberRepository  memberRepository;

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }

    public Optional<Member> infoMember(int idx) {
        return memberRepository.findById(idx);
    }

}
