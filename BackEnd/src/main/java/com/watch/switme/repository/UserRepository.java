package com.watch.switme.repository;

import com.watch.switme.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    Optional<User> findByEmail(String email);

    User findByEmailAndRealname(String email, String realname);

    User findByEmailAndPw(String email, String pw);

    boolean existsByEmail(String email);

    @Query(value = "select * from User_data u where u.user_idx = ?1", nativeQuery = true)
    User findFirstByUserIdx(Long user_idx);

//    @Modifying
//    @Query(value = "update User_data u set u.UserPassword = ?1 where u.user_idx = ?2", nativeQuery = true)
//    void updateUserPassword(String password, Long user_idx);

}
