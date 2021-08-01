package com.watch.switme.dto;


import com.watch.switme.domain.TimerDailyUser;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@NoArgsConstructor
public class CumulativeTimeDto {
    private Long cumulative_time;

    @Builder
    public CumulativeTimeDto(Long cumulative_time) {
        this.cumulative_time = cumulative_time;
    }
}
