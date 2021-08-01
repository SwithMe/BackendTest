package com.watch.switme.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@ToString(exclude = "messageList")
@Getter
@NoArgsConstructor
@Table(name="chat_room")
@Entity
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="room_idx")
    private Long roomIdx;

    @ManyToOne
    @JoinColumn(name="study_idx")
    private Study study;

    @ManyToOne
    @JoinColumn(name="leader_idx")
    private User leader;

    @ManyToOne
    @JoinColumn(name="inquirer_idx")
    private User inquirer;

    @OneToMany(mappedBy = "room")
    private List<ChatMessage> messageList;

    @Builder
    public ChatRoom(Study study, User leader, User inquirer){
        this.study = study;
        this.leader = leader;
        this.inquirer = inquirer;
    }
}
