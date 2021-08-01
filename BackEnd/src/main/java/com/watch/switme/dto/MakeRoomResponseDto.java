package com.watch.switme.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MakeRoomResponseDto {
    private Long room_idx;

    @Builder
    public MakeRoomResponseDto(Long room_idx){
        this.room_idx = room_idx;
    }

}
