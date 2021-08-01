package com.watch.switme.service;

import com.watch.switme.domain.User;
import com.watch.switme.domain.UserDataExtra;
import com.watch.switme.dto.SignUpDTO;
import com.watch.switme.repository.UserDataExtraRepository;
import com.watch.switme.repository.UserRepository;
import com.watch.switme.domain.UserRole;
import com.watch.switme.domain.UserYesOrNo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    private final UserDataExtraRepository userDataExtraRepository;

    @Transactional
    public User signUp(final SignUpDTO signUpDTO) {
        final User user = User.builder()
                .email(signUpDTO.getEmail())
                .pw(passwordEncoder.encode(signUpDTO.getPw()))
                .role(UserRole.ROLE_USER)
                .manner_temperature(70)
                .UserAgree(UserYesOrNo.Y)
                .realname(signUpDTO.getRealname())
                .isEnable(true)
                .build();
        return userRepository.save(user);
    }

    public boolean userEmailCheck(String usermail, String username){
        System.out.println(userRepository.findByEmail(usermail));
        return true;
    }

    public boolean isEmailDuplicated(final String email) {
        return userRepository.existsByEmail(email);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findByEmail(final String email) {return userRepository.findByEmail(email);}
    public User findByUserIdx(Long user_idx){
        return userRepository.findFirstByUserIdx(user_idx);
    }

    public UserDataExtra findExtraByUserIdx(Long user_idx){
        return userDataExtraRepository.findFirstByUserIdx(user_idx);
    }


}
