package com.watch.switme.repository;

import com.watch.switme.domain.ChatMessage;
import com.watch.switme.dto.ChatMessageInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    @Query(value = "select * from chat_message c " +
            "inner join ( " +
            "select u.user_idx, u.UserName, e.self_image from User_data u " +
            "left join User_data_extra e on u.user_idx = e.user_idx " +
            ") ue on c.sender_idx = ue.user_idx " +
            "where c.room_idx = ?1 ", nativeQuery = true)
    List<ChatMessageInterface> findByRoom_RoomIdx(Long room_idx);
    ChatMessage findFirstByRoom_RoomIdxOrderBySendTimeDesc(Long room_idx);
    long countByCheckReadEquals(int num);
    @Query(value = "select * from chat_message c where c.room_idx = ?1 and c.sender_idx = ?2 and c.check_read = ?3", nativeQuery = true)
    List<ChatMessage> findByRoom_RoomIdxIsAndSender_UserIdxIsAndCheckEquals(Long room_idx, Long user_idx, int num);
}
