package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.user.RequestUser;
import com.example.demo.dto.user.ResponseUser;
import com.example.demo.service.UserManagementService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserManageController {

    private final UserManagementService userService;

    // 회원 가입 - 
    // 유저아이디 중복체크는 따로 기능
    // 비밀번호 유효성 체크는 프론트에서
    @PostMapping("register")
    public void PostUserRegister(@RequestBody RequestUser.Register dto) {
        userService.registerUser(dto.getUserId(),dto.getUserName(),dto.getUserPwd());
    }

    // 로그인
    @PostMapping("login")
    public ResponseUser.Login PostUserLogin(@RequestBody RequestUser.Login dto){
        return userService.login(dto.getUserId(), dto.getUserPwd());
        // return new ResponseUser.Login(
        //     true,"",
        //     userService.getUserInfo(null, dto.getUserId())
        // );
    }
    
    //유저 정보 수정
    @PostMapping("updateProfile")
    public ResponseUser.Info PostUserUpdateProfile(@RequestBody RequestUser.UpdateProfile dto){
        userService.updateProfile(dto.getUserId(), dto.getUserName(), dto.getUserPwd());
        return userService.getUserInfo(null, dto.getUserId());
    }
    
    //게임 승패 결과 업데이트
    @PostMapping("updateWinLose")
    public ResponseUser.Info PostUserUpdateWinLose(@RequestBody RequestUser.UpdateWinLose dto){
        userService.updateWinLose(dto.getUserId(), dto.isWin());
        return userService.getUserInfo(null, dto.getUserId());
    }

    // 유저 정보 조회
    // Get으로 작업하려고 했으나 본인 조회는 세션이 유지되는 동안 한번만 조회할 때만 사용
    // 유저 정보 조회에 필요한 데이터가 현재는 userId이지만 보안에 중요한 데이터를 사용할 수도 있기에 
    // Post로 작업함 
    @PostMapping("userInfo")
    public ResponseUser.Info PostUserInfo(@RequestBody RequestUser.Info dto) {
        ResponseUser.Info userInfo = userService.getUserInfo(dto.getUserIdLookingForInfo(), dto.getUserIdToFindInfo());
        return userInfo;
    }
    
    
}
