package com.watch.switme.service;

import com.watch.switme.domain.Study;
import com.watch.switme.domain.Timer;
import com.watch.switme.domain.User;
import com.watch.switme.dto.*;
import com.watch.switme.exception.NoResultFromDBException;
import com.watch.switme.repository.StudyRepository;
import com.watch.switme.repository.TimerRepository;
import com.watch.switme.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TimerService {


    private final TimerRepository timerRepository;
    private final UserRepository userRepository;
    private final StudyRepository studyRepository;

    @Transactional
    public Long save(TimerSaveDto timerSaveDto){
        return timerRepository.save(timerSaveDto.toEntity()).getTimer_idx();
    }


    @Transactional
    public Timer findTimer(Long timer_idx){return timerRepository.findById(timer_idx).get();}

    @Transactional
    public List<TimerListResDto> getTimerList(Long user_idx){

        User user=userRepository.findById(user_idx).orElseThrow(()-> new NoResultFromDBException("데이터가 존재하지 않습니다."));;

        List <Timer> timerList=timerRepository.findByUser(user);



        System.out.println("==timerList==");
        System.out.println(timerList);

        List <TimerListResDto> timerListResDtoList =new ArrayList<>();

        for(Timer timer:timerList){
            TimerListResDto timerListResDto = TimerListResDto.builder()
                    .timer_idx(timer.getTimer_idx())
                    .name(timer.getName())
                    .duration(timer.getDuration())
                    .build();
            timerListResDtoList.add(timerListResDto);
        }

        return timerListResDtoList;
    }

    @Transactional
    public Long update(Long timer_idx, String timer_name){
        Timer timer=timerRepository.findById(timer_idx).get();
        timer.update(timer_name);

        return timer_idx;
    }

    @Transactional
    public Long create(Long user_idx, String timer_name) {

        User user=userRepository.findById(user_idx).get();

        TimerCreateRequestDto timerCreateRequestDto=TimerCreateRequestDto.builder()
                .name(timer_name)
                .user(user)
                .duration(0L)
                .build();

        return timerRepository.save(timerCreateRequestDto.toEntity()).getTimer_idx();
    }

    @Transactional
    public Long createStudytimer(Long user_idx, Long study_idx, String timer_name){
        User user=userRepository.findById(user_idx).get();
        Study study=studyRepository.findById(study_idx).get();

        TimerStudyCreateRequestDto timerStudyCreateRequestDto=TimerStudyCreateRequestDto.builder()
                .name(timer_name)
                .user(user)
                .study(study)
                .duration(0L)
                .build();

        return timerRepository.save(timerStudyCreateRequestDto.toEntity()).getTimer_idx();

    }


    @Transactional
    public void delete(Long timer_idx){
        timerRepository.deleteById(timer_idx);
    }

    @Transactional
    public void durationInitialize(){
        List <Timer> timerList=timerRepository.findAll();

        for(Timer timer:timerList){
            timer.durationInitialize(0L);
        }

    }

}
