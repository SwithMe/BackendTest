package com.watch.switme.dto;

import com.watch.switme.domain.UserYesOrNo;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Data
public class UserStudyListResponseDto {
    private Long study_idx;
    private String study_title;
    private String study_image;
    private Date start_date;
    private Date end_date;
    private int warning;
    private UserYesOrNo activate;    //check type

    @Builder
    public UserStudyListResponseDto(Long study_idx, String study_title, String study_image,
                                    Date start_date, Date end_date, int warning, UserYesOrNo activate){
        this.study_idx = study_idx;
        this.study_title = study_title;
        this.study_image = study_image;
        this.start_date = start_date;
        this.end_date = end_date;
        this.warning = warning;
        this.activate = activate;
    }
}
