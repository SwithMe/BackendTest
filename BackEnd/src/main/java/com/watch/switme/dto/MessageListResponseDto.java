package com.watch.switme.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class MessageListResponseDto {
    private Long room_idx;
    private Long sender_idx;
    private String message;
    private Date time;
    
    public MessageListResponseDto(Long room_idx, Long sender_idx, String message, Date time){
        this.room_idx = room_idx;
        this.sender_idx = sender_idx;
        this.message = message;
        this.time = time;
    }
}
