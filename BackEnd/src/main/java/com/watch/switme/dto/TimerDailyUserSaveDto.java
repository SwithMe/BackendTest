package com.watch.switme.dto;

import com.watch.switme.domain.TimerDailyUser;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.JdbcUpdateAffectedIncorrectNumberOfRowsException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class TimerDailyUserSaveDto {

    private long user_idx;
    private LocalDate date;
    private long duration;

    @Builder
    public TimerDailyUserSaveDto(long user_idx, LocalDate date, long duration) {
        this.user_idx = user_idx;
        this.date = date;
        this.duration = duration;
    }

    public TimerDailyUser toEntity(){
        return TimerDailyUser.builder()
                .userIdx(user_idx)
                .date(date)
                .duration(duration)
                .build();
    }
}
