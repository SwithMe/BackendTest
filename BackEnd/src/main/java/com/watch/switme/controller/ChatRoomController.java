package com.watch.switme.controller;

import com.watch.switme.domain.ChatRoom;
import com.watch.switme.domain.Study;
import com.watch.switme.domain.User;
import com.watch.switme.dto.*;
import com.watch.switme.dto.ChatMessageInterface;
import com.watch.switme.service.ChatRoomService;
import com.watch.switme.service.StudyService;
import com.watch.switme.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/chat")
public class ChatRoomController {
    private final ChatRoomService chatRoomService;
    private final UserService userService;
    private final StudyService studyService;

    @PostMapping("/makeroom/user")
    public MakeRoomResponseDto makeRoom(@RequestBody MakeRoomDto makeRoomDto){
        Long study_idx = makeRoomDto.getStudy_idx();
        Study study = studyService.findByStudyIdx(study_idx);

        Long inquirer_idx = makeRoomDto.getUser_idx();
        User inquirer = userService.findByUserIdx(inquirer_idx);

        Long leader_idx = makeRoomDto.getLeader_idx();
        User leader = userService.findByUserIdx(leader_idx);

        ChatRoom check = chatRoomService.findRoom(leader_idx, inquirer_idx, study_idx);
        Long room_idx;
        if(check == null){
            ChatRoomDto chatRoomDto = ChatRoomDto.builder().study(study).leader(leader).inquirer(inquirer).build();
            room_idx = chatRoomService.save(chatRoomDto);
        } else{
            room_idx = check.getRoomIdx();
        }

        MakeRoomResponseDto makeRoomResponseDto = new MakeRoomResponseDto(room_idx);
        return makeRoomResponseDto;
    }

    @PostMapping("/makeroom/leader")
    public MakeRoomResponseDto makeRoomLeader(@RequestBody MakeRoomLeaderDto makeRoomLeaderDto){
        Long study_idx = makeRoomLeaderDto.getStudy_idx();
        Study study = studyService.findByStudyIdx(study_idx);
        Long leader_idx = makeRoomLeaderDto.getLeader_idx();
        User leader = userService.findByUserIdx(leader_idx);
        Long inquirer_idx = makeRoomLeaderDto.getMember_idx();
        User inquirer = userService.findByUserIdx(inquirer_idx);

        ChatRoom check = chatRoomService.findRoom(leader_idx, inquirer_idx, study_idx);
        Long room_idx;
        if(check==null){
            ChatRoomDto chatRoomDto = ChatRoomDto.builder().study(study).leader(leader).inquirer(inquirer).build();
            room_idx = chatRoomService.save(chatRoomDto);
        } else{
            room_idx = check.getRoomIdx();
        }

        MakeRoomResponseDto makeRoomResponseDto = new MakeRoomResponseDto(room_idx);
        return makeRoomResponseDto;
    }

    @GetMapping("/room_list/{user_idx}")
    public List<RoomListResponseDto> roomList(@PathVariable("user_idx") long user_idx){

        return chatRoomService.getRoomList(user_idx);
    }

    @GetMapping("/room/{room_idx}")
    public List<ChatMessageInterface> roomDetail(@PathVariable("room_idx") Long room_idx){
        return chatRoomService.getRoomDetail(room_idx);
    }

    @DeleteMapping("/deleteroom/{room_idx}")
    public void deleteRoom(@PathVariable("room_idx") Long room_idx){
        chatRoomService.deleteRoom(room_idx);
    }
}

//외부 테이블 연결... user study
