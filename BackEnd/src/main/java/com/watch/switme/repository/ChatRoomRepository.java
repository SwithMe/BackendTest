package com.watch.switme.repository;

import com.watch.switme.domain.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    @Query(value = "select * from chat_room c where c.inquirer_idx = ?1 or c.leader_idx = ?1 ", nativeQuery = true)
    List<ChatRoom> findByUserIdx(Long inquirer_idx);

    ChatRoom findFirstByRoomIdx(Long room_idx);

    @Query(value = "select * from chat_room c where c.leader_idx = ?1 and c.inquirer_idx = ?2 and study_idx = ?3 ", nativeQuery = true)
    ChatRoom findFirstByLeaderIdxIsAndInquirerIdxIs(Long leader_idx, Long inquirer_idx, Long study_idx);
}
