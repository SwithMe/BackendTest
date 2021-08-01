package com.watch.switme.dto;

import com.watch.switme.domain.Study;
import com.watch.switme.domain.User;
import com.watch.switme.domain.UserStudy;
import com.watch.switme.domain.UserYesOrNo;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class JoinStudyDto {

    private Long userStudyIdx;
    private Long study_idx;
    private Long user_idx;
    private UserYesOrNo amLeader; // 만든사람이 리더
    private Integer warning;
    private LocalDateTime joinDate;
    private UserYesOrNo activate;

    @Builder
    public JoinStudyDto(Long study_idx, Long user_idx, Long userIdx, UserYesOrNo amLeader,
                        Integer warning, LocalDateTime joinDate, UserYesOrNo activate){
        this.study_idx = study_idx;
        this.user_idx = user_idx;
        this. amLeader = amLeader;
        this.warning = warning;
        this.joinDate = joinDate;
        this.activate =activate;

    }



}
