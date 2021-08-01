package com.watch.switme.repository;

import com.watch.switme.domain.Timer;
import com.watch.switme.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TimerRepository extends JpaRepository<Timer, Long> {
    List<Timer> findByUser(User user);
}
