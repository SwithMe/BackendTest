package com.watch.switme.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SuccessResponseDto {
    private boolean success;

    @Builder
    public SuccessResponseDto(boolean success){
        this.success = success;
    }
}
