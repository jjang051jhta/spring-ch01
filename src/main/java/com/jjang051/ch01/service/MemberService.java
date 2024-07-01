package com.jjang051.ch01.service;


import com.jjang051.ch01.dto.Member;
import com.jjang051.ch01.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    // repository
    private final MemberRepository  memberRepository;

    public Member saveMember(Member member) {
        Member saveMember = memberRepository.save(member);
        return saveMember;
    }
}
