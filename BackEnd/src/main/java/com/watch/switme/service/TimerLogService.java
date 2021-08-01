package com.watch.switme.service;

import com.watch.switme.domain.TimerLog;
import com.watch.switme.dto.TimerLogSaveDto;
import com.watch.switme.repository.TimerLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class TimerLogService {

    private final TimerLogRepository timerLogRepository;

    @Transactional
    public Long save(TimerLogSaveDto timerLogSaveDto){
        return timerLogRepository.save(timerLogSaveDto.toEntity()).getLog_idx();
    }

}
