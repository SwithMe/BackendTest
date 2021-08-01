package com.watch.switme.dto;

import com.watch.switme.domain.TimerDailyStudy;
import com.watch.switme.domain.TimerDailyUser;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class TimerDailyStudySaveDto {

    private long study_idx;
    private LocalDate date;
    private long duration;

    @Builder
    public TimerDailyStudySaveDto(long study_idx, LocalDate date, long duration) {
        this.study_idx = study_idx;
        this.date = date;
        this.duration = duration;
    }

    public TimerDailyStudy toEntity(){
        return TimerDailyStudy.builder()
                .studyIdx(study_idx)
                .date(date)
                .duration(duration)
                .build();
    }
}
