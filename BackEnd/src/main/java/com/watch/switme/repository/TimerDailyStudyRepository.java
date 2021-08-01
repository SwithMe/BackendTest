package com.watch.switme.repository;

import com.watch.switme.domain.TimerDailyStudy;
import com.watch.switme.domain.TimerDailyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface TimerDailyStudyRepository extends JpaRepository<TimerDailyStudy, Long> {


    TimerDailyStudy findByStudyIdxAndDateBetween(Long study_idx, LocalDate start, LocalDate end);

    List<TimerDailyStudy> findTop5ByDateBetweenOrderByDurationDesc(LocalDate start, LocalDate end); //Time형식은 ordering이 잘 될까..?
}
