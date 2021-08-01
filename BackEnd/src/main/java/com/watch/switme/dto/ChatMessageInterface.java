package com.watch.switme.dto;

import lombok.Getter;

import java.util.Date;

public interface ChatMessageInterface {
    Long getRoom_idx();
    Long getSender_idx();
    String getUserName();
    String getSelf_image();
    String getMessage();
    Date getSend_time();
}
