package com.watch.switme.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;


@Data
@NoArgsConstructor
@Table(name="Timer_daily_user")
@Entity
public class TimerDailyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long daily_user_idx;

    private LocalDate date;

    private Long duration;

    //fk
    @Column(name="user_idx")
    private Long userIdx;

    @Builder
    public TimerDailyUser(Long daily_user_idx, LocalDate date, Long duration, Long userIdx) {
        this.daily_user_idx = daily_user_idx;
        this.date = date;
        this.duration = duration;
        this.userIdx = userIdx;
    }

    public void update(Long duration) {
        this.duration=duration;
        System.out.println("🐭update 완료"+this.duration);
    }
}
