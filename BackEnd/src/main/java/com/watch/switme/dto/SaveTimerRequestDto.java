package com.watch.switme.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class SaveTimerRequestDto {

    /*
    timer_idx:1, timer_duration : 100, start_time:"", end_time:" "
     */

    private long timer_idx;
    private long timer_duration;

    @DateTimeFormat(pattern = "yyyy-MM-dd`T`HH:mm:ss")
    private LocalDateTime start_time;

    @DateTimeFormat(pattern = "yyyy-MM-dd`T`HH:mm:ss")
    private LocalDateTime end_time;
}
