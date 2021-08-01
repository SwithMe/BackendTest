package com.watch.switme.dto;

import com.watch.switme.domain.ChatRoom;
import com.watch.switme.domain.Study;
import com.watch.switme.domain.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatRoomDto {
    private Study study;
    private User leader;
    private User inquirer;

    @Builder
    public ChatRoomDto(Study study, User leader, User inquirer){
        this.study = study;
        this.leader = leader;
        this.inquirer = inquirer;
    }
    // 다 수정..
    public ChatRoom toEntity(){
        return ChatRoom.builder()
                .study(study)
                .leader(leader)
                .inquirer(inquirer)
                .build();
    }
}
