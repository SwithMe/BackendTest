package com.watch.switme.repository;

import com.watch.switme.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

// certified 안 쓸 거면 삭제하기.
public interface EmailUserService extends UserDetailsService {
    public User email_certified_check(User user);
    public void email_certified_update(User user);
}
