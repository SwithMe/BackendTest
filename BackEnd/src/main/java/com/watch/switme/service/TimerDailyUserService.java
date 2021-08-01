package com.watch.switme.service;

import com.watch.switme.domain.TimerDailyUser;
import com.watch.switme.dto.CumulativeTimeDto;
import com.watch.switme.dto.TimerDailyUserSaveDto;
import com.watch.switme.dto.TimerRankDto;
import com.watch.switme.exception.NoResultFromDBException;
import com.watch.switme.repository.TimerDailyUserRepository;
import com.watch.switme.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TimerDailyUserService {

    private final TimerDailyUserRepository timerDailyUserRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(TimerDailyUserSaveDto timerDailyUserSaveDto){
        return timerDailyUserRepository.save(timerDailyUserSaveDto.toEntity()).getDaily_user_idx();
    }

    @Transactional
    public Long update(Long timerDailyUserIdx, Long duration){
        TimerDailyUser timerDailyUser=timerDailyUserRepository.findById(timerDailyUserIdx).get();
        timerDailyUser.update(duration);

        return timerDailyUserIdx;
    }

    @Transactional
    public CumulativeTimeDto getTime(Long user_idx){


        LocalDate before = LocalDate.now().minusDays(1);
        LocalDate now = LocalDate.now();

        TimerDailyUser timerDailyUser = timerDailyUserRepository.findByUserIdxAndDateBetween(user_idx, now, now).orElseThrow(()-> new NoResultFromDBException("데이터가 존재하지 않습니다."));

        CumulativeTimeDto cumulativeTimeDto= CumulativeTimeDto.builder()
                .cumulative_time(timerDailyUser.getDuration())
                .build();

        System.out.println("🐱cumulativeTimeDto\n"+cumulativeTimeDto);
        return cumulativeTimeDto;
    }

    @Transactional
    public TimerDailyUser findTimerDailyUser(Long user_idx){
        LocalDate before = LocalDate.now().minusDays(1);
        LocalDate now = LocalDate.now();


        TimerDailyUser timerDailyUser;
        timerDailyUser= timerDailyUserRepository.findByUserIdxAndDateBetween(user_idx, now,now).orElse(null);

        return timerDailyUser;
    }



    @Transactional
    public List<TimerRankDto> getRank(){

        LocalDate before = LocalDate.now().minusDays(1);
        LocalDate now = LocalDate.now();

        List<TimerDailyUser> timerDailyUserList = timerDailyUserRepository.findTop5ByDateBetweenOrderByDurationDesc(now, now);

        if(timerDailyUserList.isEmpty()) throw new NoResultFromDBException("데이터가 존재하지 않습니다.");

        List <TimerRankDto> timerRankDtoList=new ArrayList<>();

        for(TimerDailyUser timerDailyUser:timerDailyUserList){
            TimerRankDto timerRankDto =TimerRankDto.builder()
                    .name(userRepository.findById(timerDailyUser.getUserIdx()).get().getRealname())
                    .cumulative_time(timerDailyUser.getDuration())
                    .build();

            timerRankDtoList.add(timerRankDto);
        }

        System.out.println("🐱timerRankDtoList\n"+timerRankDtoList);
        return timerRankDtoList;

    }
}
