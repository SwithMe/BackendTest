package com.watch.switme.dto;


import com.watch.switme.domain.Timer;
import com.watch.switme.domain.TimerLog;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@NoArgsConstructor
public class TimerLogSaveDto {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime start_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime end_time;
    private Long duration;
    private Timer timer;

    @Builder
    public TimerLogSaveDto(LocalDateTime start_time, LocalDateTime end_time, Long duration, Timer timer) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.duration = duration;
        this.timer = timer;
    }

    public TimerLog toEntity(){
        return TimerLog.builder()
                .start_time(start_time)
                .end_time(end_time)
                .duration(duration)
                .timer(timer)
                .build();
    }
}
