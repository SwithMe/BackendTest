package com.watch.switme.domain;


import com.watch.switme.dto.MakeStudyDto;
import lombok.*;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
@NoArgsConstructor(access= AccessLevel.PROTECTED)
//@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="Study_main")
@Entity(name="study_main")
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
    private Long study_idx;

    @Column(nullable=false, unique=true, length=45)
    private String title;

    @Column(nullable=false, unique=true, length=45)
    private String type;

    // 스터디 진행 시작(기간)
    @Column(nullable=false)
    private Date termstart;

    // 스터디 진행 종료(기간)
    @Column(nullable=false)
    private Date termend;

    // 스터디 시작시간
    @Column(nullable=false)
    private Time timestart;

    // 스터디 종료시간
    @Column(nullable=false)
    private Time timeend;

    // 모집 인원
    @Column(nullable=false)
    private Integer size;

    // 태그
    @Column
    private String tags;

    // 장소
    @Column
    private String location;

    // 기타 사항
    @Column
    private String extra;

    // 대표이미지
    @Column
    private String image;

    // 스터디장
    @Column
    private Long leader;

    // 링크
    @Column
    private String link;

    // 현재 진행중인지?
    @Column
    @Enumerated(EnumType.STRING) //바꿈
    private UserYesOrNo activate;

    // 한줄 소개
    @Column
    private String studyIntro;

    // 현재 인원
    @Column
    private Integer participant;

    // 평균 매너온도
    @Column
    private Integer avgMannerTemperature;

    @Builder
    public Study(Long study_idx, String title, String type, Date termstart, Date termend, Time timestart, Time timeend, Integer size, String tags, String location, String extra, String image, Long leader, String link, UserYesOrNo activate, String studyIntro, Integer participant, Integer avgMannerTemperature) {
        this.study_idx = study_idx;
        this.title = title;
        this.type = type;
        this.termstart = termstart;
        this.termend = termend;
        this.timestart = timestart;
        this.timeend = timeend;
        this.size = size;
        this.tags = tags;
        this.location = location;
        this.extra = extra;
        this.image = image;
        this.leader = leader;
        this.link = link;
        this.activate=activate;
        this.studyIntro = studyIntro;
        this.participant = participant;
        this.avgMannerTemperature = avgMannerTemperature;
    }


    public Study update(Study study, MakeStudyDto makeStudyDto){
        this.title = makeStudyDto.getTitle();
        this.type = makeStudyDto.getType();
        this.termstart = makeStudyDto.getTermstart();
        this.termend = makeStudyDto.getTermend();
        this.timestart = makeStudyDto.getTimestart();
        this.timeend = makeStudyDto.getTimeend();
        this.size = makeStudyDto.getSize();
        this.tags = makeStudyDto.getTags();
        this.location =makeStudyDto.getLocation();
        this.extra = makeStudyDto.getExtra();
        this.image = makeStudyDto.getImage();
        this.link = makeStudyDto.getLink();
        this.activate =makeStudyDto.getActivate();
        this.studyIntro = makeStudyDto.getStudyIntro();
        //this.avgMannerTemperature =study.getAvgMannerTemperature();
        return study;
    }

    public void updateParticipant(Integer participant){
        this.participant =participant;
    }
}
