package com.watch.switme.repository;

import com.watch.switme.domain.Timer;
import com.watch.switme.domain.TimerDailyUser;
//import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TimerDailyUserRepository extends JpaRepository<TimerDailyUser,Long>{

    Optional<TimerDailyUser> findByUserIdxAndDateBetween(Long user_idx, LocalDate start, LocalDate end);


    List<TimerDailyUser> findTop5ByDateBetweenOrderByDurationDesc(LocalDate start, LocalDate end); //Time형식은 ordering이 잘 될까..?
}
