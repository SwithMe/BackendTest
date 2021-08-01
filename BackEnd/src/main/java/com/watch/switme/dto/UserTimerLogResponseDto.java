package com.watch.switme.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Data
public class UserTimerLogResponseDto {
    private Long log_idx;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    private Long duration;

    @Builder
    public UserTimerLogResponseDto(Long log_idx, LocalDateTime start_time, LocalDateTime end_time, Long duration){
        this.log_idx = log_idx;
        this.start_time = start_time;
        this.end_time = end_time;
        this.duration = duration;
    }
}
