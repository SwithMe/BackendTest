package com.watch.switme.repository;

import com.watch.switme.domain.UserStudy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface
UserStudyRepository extends JpaRepository<UserStudy, Long> {

    @Query(value = "select * from User_study u where u.user_idx = ?1", nativeQuery = true)
    List<UserStudy> findByUserIdx(Long user_idx);

    @Query(value = "select * from User_study u where u.study_idx = ?1", nativeQuery = true)
    List<UserStudy> findByStudyIdx(Long study_idx);

    @Query(value = "select * from User_study u where u.study_idx = ?1 and u.user_idx = ?2", nativeQuery = true)
    UserStudy findByUserAndStudy(Long study_idx, Long user_idx);


}
