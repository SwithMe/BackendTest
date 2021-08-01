package com.watch.switme.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
@NoArgsConstructor
@Table(name="Timer_log")
@Entity
public class TimerLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long log_idx;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime start_time;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime end_time;

    private Long duration;

    @ManyToOne
    @JoinColumn(name="timer_idx")
    private Timer timer;

    @Builder
    public TimerLog(Long log_idx, LocalDateTime start_time, LocalDateTime end_time, Long duration, Timer timer) {
        this.log_idx = log_idx;
        this.start_time = start_time;
        this.end_time = end_time;
        this.duration = duration;
        this.timer = timer;
    }
}
