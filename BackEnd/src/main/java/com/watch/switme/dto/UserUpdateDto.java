package com.watch.switme.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@Data
public class UserUpdateDto {
    private Long user_idx;
    private String password;
    private MultipartFile file;

    public UserUpdateDto(Long user_idx, String password, MultipartFile file){
        this.user_idx = user_idx;
        this.password = password;
        this.file = file;
    }
}
