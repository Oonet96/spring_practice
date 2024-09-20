package com.example.demo.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class RequestUser {

    @Getter
    @AllArgsConstructor
    public class Register {
        private String userId;
        private String userName;
        private int userPwd;

        @Setter
        private String logText;
    }

    @Getter
    @AllArgsConstructor
    public class Login {
        private String userId;
        private int userPwd;
        
        @Setter
        private String logText;
    }

    @Getter
    @AllArgsConstructor
    public class UpdateProfile{
        private String userId;
        private String userName;
        private int userPwd;

        @Setter
        private String logText;
    }

    @Getter
    @AllArgsConstructor
    public class UpdateWinLose {
        private String userId;
        private boolean isWin;

        @Setter
        private String logText;
    }

    @Getter
    @AllArgsConstructor
    public class Info{
        private String userIdLookingForInfo;
        private String userIdToFindInfo;
    }
}
