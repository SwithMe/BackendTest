package com.watch.switme.repository;

import com.watch.switme.domain.UserDataExtra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDataExtraRepository extends JpaRepository<UserDataExtra, Long> {
    UserDataExtra findFirstByUserIdx(Long user_idx);

    Optional<UserDataExtra> findByUserIdx(Long user_idx);
}
