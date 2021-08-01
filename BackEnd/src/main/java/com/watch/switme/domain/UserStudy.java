package com.watch.switme.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Table(name="User_study")
@Entity
public class UserStudy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_study_idx")
    private Long userStudyIdx;

    @ManyToOne
    @JoinColumn(name = "study_idx", nullable = false)
    private Study study;

    @ManyToOne
    @JoinColumn(name = "user_idx", nullable = false)
    private User user;

    @Column(name = "am_leader", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserYesOrNo amLeader;

    @Column(name = "warning", nullable = false)
    private Integer warning;

    @CreationTimestamp
    @Column(name="join_date", nullable = false)
    private LocalDateTime joinDate;

    @Column(name = "activate")
    @Enumerated(EnumType.STRING)
    private UserYesOrNo activate;

    // 저는 조회만 하면 돼서 변수명이랑 타입만 바뀌지 않으면 효정님이 편한 방향으로 수정해서 사용하셔도 상관없어요!
    // 다만 변수명/타입이 바뀌게 되면 알려주세요
    @Builder
    public UserStudy(Study study, User user, UserYesOrNo amLeader, Integer warning, LocalDateTime joinDate, UserYesOrNo activate){
        this.study = study;
        this.user = user;
        this.amLeader = amLeader;
        this.warning = warning;
        this.joinDate = joinDate;
        this.activate = activate;
    }

    public void updateWarning(Integer warning){
        this.warning = warning;
    }
}
