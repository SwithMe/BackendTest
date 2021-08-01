package com.watch.switme.repository;

import com.watch.switme.domain.Study;
import com.watch.switme.dto.MakeStudyDto;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.security.core.parameters.P;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyRepository extends JpaRepository<Study, Long>, JpaSpecificationExecutor<Study> {
    @Query(value = "select * from Study_main s where s.study_idx = ?1", nativeQuery = true)
    Study findFirstByStudyIdx(Long study_idx);

    List<Study> findAll();

    @Query(value="SELECT * from Study_main u where u.study_idx=:sstudy_idx",nativeQuery=true)
    Study findByStudy_idx(@Param("sstudy_idx") Long study_idx);

/*
    @Query(value="select * from Study_main u where u.study_idx=:sstudy_idx", nativeQuery=true)
    List <Study> findByStudy_idx(@Param("sstudy_idx")Long study_idx);
*/

    @Query(value = "select * from Study_main u where u.title=:title", nativeQuery=true)
    List <Study> findByTitle(@Param("title")String title);

    List<Study> findTop12ByTypeOrderByAvgMannerTemperatureDesc(String type);

    List<Study> findAllByTitleAndActivateAndLeaderAndParticipantAndSize(String title, String activate, Long leader, int participant, int size);

    List<Study> findAllByLeader(@Param("leader")Long leader);

    List<Study> findAllByleader(int leader);

    //DB 검색 추가조건 수정
    @Query(value="select * from Study_main u where u.leader=:sleader and u.title=:stitle and u.size=:ssize and u.type=:stype and u.activate=:sactive", nativeQuery=true)
    List<Study> getQuery(@Param("sleader")Long leader, @Param("stitle")String title, @Param("ssize")int size, @Param("stype")String type, @Param("sactive")String activate);

    //DB 필터링 조건 추가
    @Query(value="select * from Study_main u WHERE (:sleader is null or u.leader=:sleader) and (:stitle is null or u.title like concat('%', :stitle, '%')) and (:ssize is null or u.size=:ssize) and (:stags is null or u.tags like concat('%', :stags, '%')) and (:stype is null or u.type=:stype)", nativeQuery=true)
    List<Study> getFilterQuery(@Param("sleader")String leader, @Param("stitle")String title, @Param("ssize")int size, @Param("stags")String tags, @Param("stype")String type);

    /*
    /*쿼리모음*/
    List<Study> findAllByTitleContaining(String title);
    List<Study> findAllBySize(int size);
    List<Study> findAllByType(String type);
    List<Study> findAllByActivate(String active);
    List<Study> findAllByTagsContaining(String tags);
    //
}
