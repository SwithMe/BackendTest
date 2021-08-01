package com.watch.switme.dto;

import com.watch.switme.domain.UserYesOrNo;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor(force = true)
public class StudyListResponseDto {

    //확인필요
    private String leader_image;
    private String leader_name;

    private Long study_idx;
    private String title;
    private String type;
    //private Date termstart;
    //private Date termend;
    //private Time timestart;
    //private Time timeend;
    private Integer size;
    private String tags;
    //private String location;
    private String image;
    private Long leader;
    //private String link;
    //private String studyIntro;
    private UserYesOrNo activate;
    private int participant;
    //private int manner_temperature;
    private int avgMannerTemperature;

    @Builder
    public StudyListResponseDto(Long study_idx, String title, String type, Integer size, String tags, String image, Long leader,
                             UserYesOrNo activate, int participant, int avgMannerTemperature
    , String leader_image, String leader_name){
        this.study_idx = study_idx;
        this.title = title;
        this.type = type;
        this.size = size;
        this.tags = tags;
        this.image = image;
        this.leader = leader;
        this.activate = activate;
        this.participant = participant;
        this.avgMannerTemperature = avgMannerTemperature;
        this.leader_image=leader_image;
        this.leader_name=leader_name;}

}
