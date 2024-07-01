package com.jjang051.ch01.service;

import com.jjang051.ch01.dto.Member;
import com.jjang051.ch01.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class MemberServiceTest {
    @Autowired
    MemberRepository memberRepository = new MemberRepository();
    @Test
    @DisplayName("member repoitory에서 저장한 member 랑 리턴되는 merber가 같다.")
    void saveMember() {
        Member member = Member.builder()
                .userName("장성호")
                .userId("jjang051")
                .userPw("1234")
                .build();
        Member savedMember = memberRepository.save(member);

        assertThat(member).isEqualTo(savedMember);
        //Assertions.assertThat(1+1).isEqualTo(2);
    }


    @DisplayName("1+2=3")
    @Test
    void test03() {
        assertThat(1+1).isEqualTo(2);
    }

    @Test
    @DisplayName("숫자 테스트")
    void test04() {
        int num01=10;
        int num02=0;
        int num03=-20;
        String userName="장성호";
        String dbName="장동건";
        assertThat(num01).isPositive();
        assertThat(num02).isZero();
        assertThat(num03).isNegative();
        assertThat(userName).isNotNull();
        assertThat(dbName).isNotNull();
        assertThat(userName).isNotEqualTo(dbName);
    }
}