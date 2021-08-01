package com.watch.switme.service;

import com.watch.switme.domain.ChatMessage;
import com.watch.switme.domain.ChatRoom;
import com.watch.switme.dto.ChatMessageDto;
import com.watch.switme.repository.ChatMessageRepository;
import com.watch.switme.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomRepository chatRoomRepository;

    @Transactional
    public void save(ChatMessageDto chatMessageDto){
        chatMessageRepository.save(chatMessageDto.toEntity());
    }

    @Transactional
    public void updateCheck(Long room_idx, Long user_idx){
        ChatRoom chatRoom = chatRoomRepository.findFirstByRoomIdx(room_idx);
        Long other_idx;

        if(chatRoom.getInquirer().getUser_idx() == user_idx){
            other_idx = chatRoom.getLeader().getUser_idx();
        } else {
            other_idx = chatRoom.getInquirer().getUser_idx();
        }

        List<ChatMessage> chatMessageList = chatMessageRepository
                .findByRoom_RoomIdxIsAndSender_UserIdxIsAndCheckEquals(room_idx, other_idx, 0);

        for(ChatMessage chatMessage: chatMessageList){
            chatMessage.checkUpdate(1);
        }

    }
}
