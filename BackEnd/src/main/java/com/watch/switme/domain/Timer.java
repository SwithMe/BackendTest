package com.watch.switme.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@Data
@NoArgsConstructor
@Entity
public class Timer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timer_idx;

    @Column(name = "timer_name")
    private String name;

    private Long duration;

    @ManyToOne
    @JoinColumn(name="user_idx")
    private User user;

    @ManyToOne
    @JoinColumn(name="study_idx")
    private Study study;


    @Builder
    public Timer(Long timer_idx, String name, Long duration, User user, Study study) {
        this.timer_idx = timer_idx;
        this.name = name;
        this.duration = duration;
        this.user = user;
        this.study = study;
    }

    public void update(String timer_name){
        this.name=timer_name;
    }

    public void durationInitialize(Long duration){this.duration=duration;}

}
