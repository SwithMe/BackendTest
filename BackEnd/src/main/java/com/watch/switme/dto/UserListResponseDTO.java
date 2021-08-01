package com.watch.switme.dto;

import com.watch.switme.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class UserListResponseDTO {

    private final List<User> userList;

}
