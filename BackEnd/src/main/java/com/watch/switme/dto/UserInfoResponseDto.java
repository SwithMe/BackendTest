package com.watch.switme.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserInfoResponseDto {
    private Long user_idx;
    private String user_name;
    private String user_email;
    private String user_image;
    private int user_manner;

    @Builder
    public UserInfoResponseDto(Long user_idx, String user_name, String user_email, String user_image, int user_manner){
        this.user_idx = user_idx;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_image = user_image;
        this.user_manner = user_manner;
    }
}
