package com.example.demo.service.game;

import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.example.demo.util.GameRoomData;

@Service
@RequiredArgsConstructor
public class GameManagementService {

    private GameRoomService roomService;
    private BaseballService baseballService;

    public Map<Integer,GameRoomData> CreateGame(int entryCode,String userId,String roomText){
        
        roomService.createGame(entryCode,userId,roomText);
        
        return roomService.getGameRoom();
    }

    public void JoinGame(int entryCode,String userId){
        roomService.joinGame(entryCode,userId);
    }

    public void StartGame(int entryCode){
        roomService.startGame(entryCode);
    }

    public void EndGame(int entryCode){

    }

    public void GetGameState(int entryCode){

    }

    public Map<Integer,GameRoomData> GetGameRoom(){
        return roomService.getGameRoom();
    }
    
    // 게임 시작 후 번호 선정
    public void SelectedNumber(){

    }

    

}
