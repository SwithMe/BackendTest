package com.watch.switme.dto;

import lombok.*;
import java.sql.Timestamp;

@Data
public class showStudyDto {
    private Integer study_idx;
    private String title;
    private String type;
    private Timestamp termstart;
    private Timestamp termend;
    private Timestamp timestart;
    private Timestamp timeend;
    private Integer size;
    private String tags;
    private String location;
    private String extra;
    private String image;
    private Integer leader;
    private String link;
    private String activate;
    private String studyIntro;
    private Integer participant;
    private Integer avgMannerTemperature;

    public showStudyDto(Integer study_idx, String title, String type, Timestamp termstart, Timestamp termend, Integer size,
                        String tags, String location, String extra, String image, Integer leader, String link, String activate, String studyIntro,
                        Integer participant, Integer avgMannerTemperature){
        this.study_idx = study_idx;
        this.title = title;
        this.type = type;
        this.termstart = termstart;
        this.termend = termend;
        this.size = size;
        this.tags = tags;
        this.location = location;
        this.extra = extra;
        this.image = image;
        this.leader = leader;
        this.link = link;
        this.activate = activate;
        this.studyIntro = studyIntro;
        this.participant = participant;
        this.avgMannerTemperature = avgMannerTemperature;
    }
}
