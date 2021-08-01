package com.watch.switme.service;

import com.watch.switme.domain.TimerDailyStudy;
import com.watch.switme.domain.TimerDailyUser;
import com.watch.switme.dto.TimerDailyStudySaveDto;
import com.watch.switme.dto.TimerDailyUserSaveDto;
import com.watch.switme.dto.TimerRankDto;
import com.watch.switme.exception.NoResultFromDBException;
import com.watch.switme.repository.StudyRepository;
import com.watch.switme.repository.TimerDailyStudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TimerDailyStudyService {
    private final TimerDailyStudyRepository timerDailyStudyRepository;
    private final StudyRepository studyRepository;

    @Transactional
    public Long update(Long timerDailyStudyIdx, Long duration){
        TimerDailyStudy timerDailyStudy=timerDailyStudyRepository.findById(timerDailyStudyIdx).get();
        timerDailyStudy.update(duration);
        return timerDailyStudyIdx;
    }

    @Transactional
    public Long save(TimerDailyStudySaveDto timerDailyStudySaveDto){
        return timerDailyStudyRepository.save(timerDailyStudySaveDto.toEntity()).getDaily_study_idx();
    }

    @Transactional
    public TimerDailyStudy findTimerDailyStudy(Long study_idx){
        LocalDate before = LocalDate.now().minusDays(1);
        LocalDate now = LocalDate.now();

        TimerDailyStudy timerDailyStudy=timerDailyStudyRepository.findByStudyIdxAndDateBetween(study_idx, now,now);

        return timerDailyStudy;
    }

    @Transactional
    public List<TimerRankDto> getRank(){

        LocalDate before = LocalDate.now().minusDays(1);
        LocalDate now = LocalDate.now();

        List<TimerDailyStudy> timerDailyStudyList = timerDailyStudyRepository.findTop5ByDateBetweenOrderByDurationDesc( now,  now);

        if(timerDailyStudyList.isEmpty()) throw new NoResultFromDBException("데이터가 존재하지 않습니다.");
        List <TimerRankDto> timerRankDtoList=new ArrayList<>();


            for(TimerDailyStudy timerDailyStudy:timerDailyStudyList){
            TimerRankDto timerRankDto = TimerRankDto.builder()
                    .name(studyRepository.findById(timerDailyStudy.getStudyIdx()).get().getTitle())
                    .cumulative_time(timerDailyStudy.getDuration())
                    .build();

            timerRankDtoList.add(timerRankDto);
        }

        return timerRankDtoList;
    }

}
