package com.watch.switme.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "User_data_extra")
@Entity
public class UserDataExtra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idx", nullable = false)
    private Long idx;

    @Column(name="self_image")
    private String selfImage;

    //fk
    @Column(name="user_idx")
    private Long userIdx;

    @Builder
    public UserDataExtra(String selfImage, Long userIdx){
        this.selfImage = selfImage;
        this.userIdx = userIdx;
    }

    public void updateUserImage(String image){
        this.selfImage = image;
    }
}
