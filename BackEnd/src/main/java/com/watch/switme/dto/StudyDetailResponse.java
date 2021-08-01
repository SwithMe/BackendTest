package com.watch.switme.dto;

import com.watch.switme.domain.UserYesOrNo;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;


@NoArgsConstructor
@Data
@Getter
@Setter
public class StudyDetailResponse {
    private Long study_idx;
    private String title;
    private String type;
    private Date termstart;
    private Date termend;
    private Time timestart;
    private Time timeend;
    private Integer size;
    private String tags;
    private String location;
    private String extra;
    private String image;
    private Long leader;
    private String link;
    private String studyIntro;
    private UserYesOrNo activate;
    private int participant;
    private int manner_temperature;
    private String leader_name;


    //삭제

    @Builder
    public StudyDetailResponse(Long study_idx, String title, String type, Date termstart, Date termend, Time timestart, Time timeend, Integer size,
                        String tags, String location, String extra, String image, Long leader, String link, String studyIntro, int manner_temperature,String leader_name,UserYesOrNo activate, int participant){
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
        this.studyIntro = studyIntro;
        this.manner_temperature=manner_temperature;
        this.leader_name=leader_name;
        this.activate=activate;
        this.participant = participant;
    }
}
