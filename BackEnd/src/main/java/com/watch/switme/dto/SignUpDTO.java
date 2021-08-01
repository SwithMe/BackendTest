package com.watch.switme.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpDTO {
    //회원가입 시 받는 3가지 main정보.
    private String email; // 이메일
    private String pw; // 비밀번호
    private String realname; // 이름


    @Builder
    public void builder(String email, String pw, String realname) {
        this.email=email;
        this.pw=pw;
        this.realname=realname;
    }
}
