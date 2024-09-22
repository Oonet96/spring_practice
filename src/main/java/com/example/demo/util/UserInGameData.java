package com.example.demo.util;

import lombok.Getter;
import lombok.Setter;

@Getter
public class UserInGameData {
    private String userId;

    @Setter
    private int[] ballArr;

    public UserInGameData(String userId){
        this.userId = userId;
        ballArr = null;
    }
}
