package com.watch.switme.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MakeRoomLeaderDto {
    private Long study_idx;
    private Long leader_idx;
    private Long member_idx;

}
