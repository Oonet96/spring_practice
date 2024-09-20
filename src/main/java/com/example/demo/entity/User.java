package com.example.demo.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int userNo;

    @Column(nullable = false)
    private String userId;

    @Column(length = 20, nullable = false)
    private String userName;

    @Column(nullable = false)
    private int userPwd;

    @Column
    private int winCount;

    @Column
    private int loseCount;


    public User(String userId,String userName,int userPwd){
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.winCount = 0;
        this.loseCount = 0;
    }
}
