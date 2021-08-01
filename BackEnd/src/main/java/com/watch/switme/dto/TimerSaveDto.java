package com.watch.switme.dto;


import com.watch.switme.domain.Study;
import com.watch.switme.domain.Timer;
import com.watch.switme.domain.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TimerSaveDto {

    private Long timer_idx;
    private String name;
    private Long duration;
    private User user;
    private Study study;

    @Builder
    public TimerSaveDto(Long timer_idx,String name, Long duration, User user, Study study) {
        this.timer_idx=timer_idx;
        this.name = name;
        this.duration = duration;
        this.user = user;
        this.study = study;
    }

    public Timer toEntity(){
        return Timer.builder()
                .timer_idx(timer_idx)
                .name(name)
                .duration(duration)
                .user(user)
                .study(study)
                .build();
    }
}
