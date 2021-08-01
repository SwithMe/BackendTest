package com.watch.switme.dto;


import com.watch.switme.domain.Study;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecomStudyResDto {

    private Long study_idx;
    private String type;
    private String title;
    private Integer participant;
    private Integer avgMannerTemperature;
    private String tags;
    private String image;

    public Study toEntity(){
        Study study=Study.builder()
                .study_idx(study_idx)
                .type(type)
                .title(title)
                .participant(participant)
                .avgMannerTemperature(avgMannerTemperature)
                .tags(tags)
                .image(image)
                .build();
        return study;
    }

    @Builder

    public RecomStudyResDto(Long study_idx, String type, String title, Integer participant, Integer avgMannerTemperature, String tags, String image) {
        this.study_idx = study_idx;
        this.type = type;
        this.title = title;
        this.participant = participant;
        this.avgMannerTemperature = avgMannerTemperature;
        this.tags = tags;
        this.image = image;
    }
}
