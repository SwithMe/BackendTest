package com.watch.switme.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class SocketDto {
    private String room_idx;
    private String user_idx;
    private String user_name;
    private String message;
    private LocalDateTime time;
}
