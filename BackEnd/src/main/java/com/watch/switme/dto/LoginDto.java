package com.watch.switme.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    //로그인 시 받는 3가지 main정보.
    private String realname;
    private String email; // 이메일
    private String pw; // 비밀번호
}
