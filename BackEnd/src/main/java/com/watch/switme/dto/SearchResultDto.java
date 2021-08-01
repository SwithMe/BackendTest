package com.watch.switme.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchResultDto {
    //검색시 리턴값.
    private String title;
    private String activate;
    private int participant;
    private int size;
    private String tags;
    private String online;
    //추가 정보
    private Long leader_idx;
    private String leader_name;
}