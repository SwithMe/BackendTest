package com.watch.switme.dto;

import com.watch.switme.domain.Study;
import com.watch.switme.domain.Timer;
import com.watch.switme.domain.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TimerStudyCreateRequestDto {

    private String name;
    private User user;
    private Study study;
    private Long duration;

    @Builder

    public TimerStudyCreateRequestDto(String name, User user, Study study, Long duration) {
        this.name = name;
        this.user = user;
        this.study = study;
        this.duration = duration;
    }


    public Timer toEntity(){
        return Timer.builder()
                .name(name)
                .user(user)
                .study(study)
                .duration(duration)
                .build();
    }
}
