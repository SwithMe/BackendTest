package com.watch.switme.controller;

import com.watch.switme.dto.CumulativeTimeDto;
import com.watch.switme.dto.TimerRankDto;
import com.watch.switme.service.TimerDailyStudyService;
import com.watch.switme.service.TimerDailyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RequiredArgsConstructor
@RestController
public class TimerDailyController {

    private final TimerDailyUserService timerDailyUserService;
    private final TimerDailyStudyService timerDailyStudyService;


    //나의 누적 공부시간
    @GetMapping("/main/mytime/{user_idx}")
    public ResponseEntity timerList(@PathVariable("user_idx") long user_idx){
        return ResponseEntity.ok().body(timerDailyUserService.getTime(user_idx));
    }

    //누적 공부 시간 랭킹 (개인)
    @GetMapping("/main/rank/individual")
    public ResponseEntity getUserRank(){
        return ResponseEntity.ok().body(timerDailyUserService.getRank());
    }


    //누적 공부 시간 랭킹 (스터디)

    @GetMapping("/main/rank/study")
    public ResponseEntity getStudyRank(){
        return ResponseEntity.ok().body(timerDailyStudyService.getRank());
    }

}
