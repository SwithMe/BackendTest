package com.watch.switme.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "User_data")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_idx", nullable = false)
    private Long user_idx;

    @CreationTimestamp
    @Column(name="UserJoin", nullable = false, length = 20, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(length = 20)
    private LocalDateTime updatedAt;

    @Setter
    @Column(name="auth", columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean isEnable;

    @Setter
    @Column(name="UserName", nullable = true)
    private String realname;

    @Column(name="UserEmail", nullable = false, unique = true, length = 50)
    private String email;

    @Setter
    @Column(name="UserPassword", nullable = false)
    private String pw;

    @Setter
    @Column(name="UserAgree", nullable = true)
    @Enumerated(EnumType.STRING)
    private UserYesOrNo UserAgree;

    @Setter
    @Column(name="manner_temperature", nullable = true)
    private int manner_temperature;

    @Setter
    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserRole role;

//    public void updateUserPassword(String pw){
//        this.pw = pw;
//    }


}
