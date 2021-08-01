package com.watch.switme.controller;

import com.watch.switme.domain.ChatRoom;
import com.watch.switme.domain.User;
import com.watch.switme.dto.ChatMessageDto;
import com.watch.switme.dto.DisconnectDto;
import com.watch.switme.dto.SocketDto;
import com.watch.switme.service.ChatRoomService;
import com.watch.switme.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Controller
public class ChatController {
    private final SimpMessageSendingOperations messagingTemplate;
    private final ChatMessageService chatMessageService;
    private final ChatRoomService chatRoomService;

    @MessageMapping("/chat/message")
    public void Message(SocketDto message){
        ChatRoom presentRoom = chatRoomService.findByRoomIdx(Long.parseLong(message.getRoom_idx()));
        User sender;
        if(Long.parseLong(message.getUser_idx()) == presentRoom.getInquirer().getUser_idx()){
            sender = presentRoom.getInquirer();
        } else{
            sender = presentRoom.getLeader();
        }
        LocalDateTime now = LocalDateTime.now();

        ChatMessageDto chatMessageDto = ChatMessageDto.builder()
                .message(message.getMessage())
                .sender(sender)
                .room(presentRoom)
                .time(now)
                .check(0)
                .build();

        chatMessageService.save(chatMessageDto);

        message.setTime(now);
        messagingTemplate.convertAndSend("/topic/"+message.getRoom_idx(), message);
    }

    @MessageMapping("/disconnect")
    public void Disconnect(DisconnectDto disconnect){
        String room_idx = disconnect.getRoom_idx();
        String user_idx = disconnect.getUser_idx();

        chatMessageService.updateCheck(Long.parseLong(room_idx), Long.parseLong(user_idx));
    }
}
