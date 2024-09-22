package com.example.demo.util;

import lombok.Setter;

public class GameRoomData {

    private int entryCode;

    private UserInGameData user1;

    @Setter
    private UserInGameData user2;
    
    private String roomText;

    public enum roomState{
        CREATED,
        USERENTER,
        STARTED,
        END
    };

    @Setter
    private roomState enumState = roomState.CREATED;

    public GameRoomData(int entryCode,String userId, String roomText){
        this.entryCode = entryCode;
        this.user1 = new UserInGameData(userId);
        this.user2 = null;
        this.roomText = roomText;
        this.enumState = roomState.CREATED;
    }
}
