package com.watch.switme.service;

import com.watch.switme.domain.ChatMessage;
import com.watch.switme.domain.ChatRoom;
import com.watch.switme.domain.UserDataExtra;
import com.watch.switme.dto.ChatRoomDto;
import com.watch.switme.dto.RoomListResponseDto;
import com.watch.switme.repository.ChatMessageRepository;
import com.watch.switme.repository.ChatRoomRepository;
import com.watch.switme.dto.ChatMessageInterface;
import com.watch.switme.repository.UserDataExtraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final UserDataExtraRepository userDataExtraRepository;

    @Transactional
    public ChatRoom findRoom(Long leader_idx, Long inquirer_idx, Long study_idx){
        return chatRoomRepository.findFirstByLeaderIdxIsAndInquirerIdxIs(leader_idx, inquirer_idx, study_idx);
    }

    @Transactional
    public Long save(ChatRoomDto chatRoomDto){
        return chatRoomRepository.save(chatRoomDto.toEntity()).getRoomIdx();
    }

    @Transactional
    public List<RoomListResponseDto> getRoomList(Long user_idx){
        List<ChatRoom> chatRoomList = chatRoomRepository.findByUserIdx(user_idx);
        List<RoomListResponseDto> roomListResponseDtoList = new ArrayList<>();

        for(ChatRoom room : chatRoomList){
            ChatMessage chatMessage = chatMessageRepository.findFirstByRoom_RoomIdxOrderBySendTimeDesc(room.getRoomIdx());
            System.out.println(chatMessage);
            String message;
            if (chatMessage == null) {
                message = "";
            }else{
                message = chatMessage.getMessage();
            }
            System.out.println(message);

            String room_name = room.getStudy().getTitle();
            Long other_idx;
            String other_user;

            if(room.getInquirer().getUser_idx() == user_idx){
                other_idx = room.getLeader().getUser_idx();
                other_user = room.getLeader().getRealname();

            } else{
                other_idx = room.getInquirer().getUser_idx();
                other_user = room.getInquirer().getRealname();
            }

            UserDataExtra userDataExtra = userDataExtraRepository.findFirstByUserIdx(other_idx);
            String other_image;
            if(userDataExtra == null){
                other_image = null;
            } else{
                other_image = userDataExtra.getSelfImage();
            }

            RoomListResponseDto roomListResponseDto = RoomListResponseDto.builder()
                    .room_idx(room.getRoomIdx())
                    .room_name(room_name)
                    .other_user(other_user)
                    .user_image(other_image)
                    .message(message)
                    .notification(chatMessageRepository.countByCheckReadEquals(0))
                    .build();

            roomListResponseDtoList.add(roomListResponseDto);
        }

        return roomListResponseDtoList;
    }

    @Transactional
    public List<ChatMessageInterface> getRoomDetail(Long room_idx){

        return chatMessageRepository.findByRoom_RoomIdx(room_idx);
    }

    @Transactional
    public void deleteRoom(Long room_idx){
        chatRoomRepository.deleteById(room_idx);
    }

    @Transactional
    public ChatRoom findByRoomIdx(Long room_idx){
        return chatRoomRepository.findById(room_idx).get();
    }
}
