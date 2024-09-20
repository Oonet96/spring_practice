package com.example.demo.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.dto.ResponseUser;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Service
@Component
@RequiredArgsConstructor
public class UserManagementService {

    private final UserRepository userRepo;

    public void registerUser(String userId, String userName, int userPwd){
        userRepo.save(new User(userId,userName,userPwd));
    }

    //비밀번호 해시값으로 저장해두고, 가져와서 비교 할것
    @Transactional(readOnly = true)
    public ResponseUser.Login login(String userId, int userPwd){
        Optional<User> optTemp = userRepo.findByUserId(userId);
        ResponseUser.Login resData = new ResponseUser.Login();
        
        resData.setBSuccess(false); 
        
        if(optTemp.isEmpty()){
            resData.setLogText("[login] 아이디가 존재하지 않습니다.");
            return resData;
        }
        
        User temp = optTemp.get();

        if(temp.getUserPwd() == userPwd){
            resData.setBSuccess(true); 
            resData.setLogText("[login] 로그인 성공");
            resData.setUserInfo(getUserInfo(null,userId));
        }
        else resData.setLogText("[login] 비밀번호가 틀립니다.");
        
        return resData;
    }

    public String updateProfile(String userId, String userName, int userPwd){
        Optional<User> optTemp = userRepo.findByUserId(userId);

        if(optTemp.isEmpty()) return "[updateProfile] 유저정보가 일치하지 않습니다.";

        User tmpData = optTemp.get();

        tmpData.setUserName(userName);
        tmpData.setUserPwd(userPwd);

        userRepo.save(tmpData);

        return "[updateProfile] 유저정보가 업데이트 되었습니다.";
    }

    public String updateWinLose(String userId, boolean isWin){
        Optional<User> optTemp = userRepo.findByUserId(userId);

        if(optTemp.isEmpty()) return "[updateWinLose] 유저정보가 일치하지 않습니다.";

        User tmpData = optTemp.get();

        if(isWin) tmpData.setWinCount(tmpData.getWinCount()+1); 
        else tmpData.setLoseCount(tmpData.getLoseCount()+1);

        userRepo.save(tmpData);

        return "[updateWinLose] 유저정보가 업데이트 되었습니다.";
    }

    @Transactional(readOnly = true)
    public ResponseUser.Info getUserInfo(String userIdLookingForInfo, String userIdToFindInfo){
        boolean bSelf = userIdLookingForInfo == null;

        Optional<User> optTemp = userRepo.findByUserId(userIdToFindInfo);
        
        if(optTemp.isEmpty()) return new ResponseUser.OtherInfo("",0,0,"유저정보가 없습니다.");

        User tmpData = optTemp.get();
        
        return bSelf 
            ? new ResponseUser.SelfInfo(tmpData.getUserId(),tmpData.getUserName(),tmpData.getWinCount(),tmpData.getLoseCount(),"success") 
            : new ResponseUser.OtherInfo(tmpData.getUserName(), tmpData.getWinCount(), tmpData.getLoseCount(), "success");
    }
}
