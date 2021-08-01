package com.watch.switme.dto;


import com.watch.switme.domain.Study;
import com.watch.switme.domain.Timer;
import com.watch.switme.domain.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@NoArgsConstructor
public class TimerListResDto {
    private Long timer_idx;
    private String name;
    private Long duration;

    public Timer toEntity(){
        Timer timer=Timer.builder()
                .timer_idx(timer_idx)
                .name(name)
                .duration(duration)
                .build();
        return timer;
    }

    @Builder
    public TimerListResDto(Long timer_idx, String name, Long duration) {
        this.timer_idx = timer_idx;
        this.name = name;
        this.duration = duration;
    }
}
