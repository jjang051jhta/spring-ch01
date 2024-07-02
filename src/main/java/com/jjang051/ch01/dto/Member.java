package com.jjang051.ch01.dto;

import jakarta.validation.constraints.*;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
    private int idx;

    @NotBlank(message = "사용자 이름은 필수 입력사항입니다.")
    private String userName;

    @NotBlank(message = "password는 필수 입력사항입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}",
            message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String userPw;

    @NotBlank(message = "id는 필수 입력사항입니다.")
    @Size(min = 5, max = 10, message = "id는 5글자 이상 10글자 미만이어야 합니다.")
    private String userId;

    @Email(message = "email은 필수 입력사항입니다.")
    @NotBlank(message = "email은 필수 입력사항입니다.")
    private String userEmail;


    @Builder
    public Member(String userId,String userEmail,String userPw, String userName) {
        this.userId= userId;
        this.userName= userName;
        this.userPw = userPw;
        this.userEmail= userEmail;
    }
}
