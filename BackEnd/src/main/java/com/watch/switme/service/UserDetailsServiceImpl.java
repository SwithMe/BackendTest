package com.watch.switme.service;

import com.watch.switme.domain.MyUserDetails;
import com.watch.switme.repository.UserRepository;
import com.watch.switme.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    //존재하지 않는 이메일이면..
    @Override
    public MyUserDetails loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .map(u -> new MyUserDetails(u, Collections.singleton(new SimpleGrantedAuthority(u.getRole().getValue()))))
                .orElseThrow(() -> new UserNotFoundException(email+"은 존재하지 않습니다."));
    }


}
