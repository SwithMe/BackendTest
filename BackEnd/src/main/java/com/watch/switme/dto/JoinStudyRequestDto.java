package com.watch.switme.dto;


import com.watch.switme.domain.Study;
import com.watch.switme.domain.User;
import com.watch.switme.domain.UserStudy;
import com.watch.switme.domain.UserYesOrNo;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class JoinStudyRequestDto {

    private Study study;
    private User user;
    private UserYesOrNo amLeader; // 만든사람이 리더
    private Integer warning;
    private LocalDateTime joinDate;
    private UserYesOrNo activate;

    @Builder
    public JoinStudyRequestDto(Study study, User user, UserYesOrNo amLeader,
                               Integer warning, LocalDateTime joinDate, UserYesOrNo activate) {
        this.study = study;
        this.user = user;
        this.amLeader = amLeader;
        this.warning = warning;
        this.joinDate = joinDate;
        this.activate = activate;
    }

    public UserStudy toEntity() {
        return UserStudy.builder()
                .user(user)
                .study(study)
                .joinDate(joinDate)
                .amLeader(amLeader)
                .activate(activate)
                .warning(warning)
                .build();
    }
}