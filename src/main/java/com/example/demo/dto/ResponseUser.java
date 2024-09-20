package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ResponseUser {

    public interface Info {
    
    }


    @Getter
    @AllArgsConstructor
    public static class SelfInfo implements Info {
        private String userId;
        private String userName;
        private int winCount;
        private int loseCount;

        @Setter
        private String logText;
    }

    @Getter
    @AllArgsConstructor
    public static class OtherInfo implements Info {
        private String userName;
        private int winCount;
        private int loseCount;

        @Setter
        private String logText;
    }
    
    @AllArgsConstructor
    public  static class Login{
        private boolean bSuccess;
        private String logText;
        private ResponseUser.Info userInfo;

    }
}
