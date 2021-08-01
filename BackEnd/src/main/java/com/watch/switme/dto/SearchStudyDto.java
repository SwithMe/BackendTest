package com.watch.switme.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchStudyDto {
    //검색 시 받는 조건
    private String title;
    private String activate;
    private int participant;
    private int size;
    private String tags;
    private String type;
    private String leader;
}
