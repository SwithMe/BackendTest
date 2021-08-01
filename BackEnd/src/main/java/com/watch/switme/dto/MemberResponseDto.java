package com.watch.switme.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MemberResponseDto {
    private Long user_idx;
    private String user_name;
    private String user_image;
    private int user_manner;
    private int user_warning;

    @Builder
    public MemberResponseDto(Long user_idx, String user_name, String user_image, int user_manner, int user_warning){
        this.user_idx = user_idx;
        this.user_name = user_name;
        this.user_image = user_image;
        this.user_manner = user_manner;
        this.user_warning = user_warning;
    }
}
