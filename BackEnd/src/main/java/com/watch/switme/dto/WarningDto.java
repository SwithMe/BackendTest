package com.watch.switme.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class WarningDto {
    private Long study_idx;
    private Long user_idx;

    public WarningDto(Long study_idx, Long user_idx){
        this.study_idx = study_idx;
        this.user_idx = user_idx;
    }
}
