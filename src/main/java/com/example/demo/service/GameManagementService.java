package com.example.demo.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service
@Component
public class GameManagementService {

    @Getter
    private class GameRoomInfo{
        private int entryCode;
        private String userId1;

        @Setter
        private String userId2;
        
        private String roomText;

        @Setter
        private int[] userBallArr1;
        @Setter
        private int[] userBallArr2;

    
        private enum roomState{
            created,
            userEnter,
            started,
            end
        };

        @Setter
        private roomState enumState = roomState.created;

        public GameRoomInfo(int entryCode,String userId, String roomText){
            this.entryCode = entryCode;
            this.userId1 = userId;
            this.userId2 = null;
            this.roomText = roomText;
            this.userBallArr1 = null;
            this.userBallArr2 = null;
            enumState = roomState.created;
        }
    }

    private Map<Integer,GameRoomInfo> m_dicRoom = new HashMap<Integer,GameRoomInfo>();

    //Public
    public Map<Integer,GameRoomInfo> CreateGame(int entryCode,String userId,String roomText){
        
        createGame(entryCode,userId,roomText);
        
        return getGameRoom();
    }

    public void JoinGame(int entryCode,String userId){
        joinGame(entryCode,userId);
    }

    public void StartGame(int entryCode){
        startGame(entryCode);
    }

    public void EndGame(int entryCode){

    }

    public void GetGameState(int entryCode){

    }

    public Map<Integer,GameRoomInfo> GetGameRoom(){
        return getGameRoom();
    }
    //Public End

    //private
    private void createGame(int entryCode,String userId,String roomText){
        
        Set<Integer> temp = m_dicRoom.keySet();
        Iterator<Integer> entryCodes = temp.iterator();

        while(entryCodes.hasNext()){
            if(entryCodes.next() == entryCode){
                System.out.println("[GameManagementService.createGame()] entryCodes.next() == entryCode!!");
                return;
            }
        }

        m_dicRoom.put(entryCode,new GameRoomInfo(entryCode, userId, roomText));
    }

    private void joinGame(int entryCode,String userId){
        if(m_dicRoom.containsKey(entryCode)){
            m_dicRoom.get(entryCode).setUserId2(userId);
            m_dicRoom.get(entryCode).setEnumState(GameRoomInfo.roomState.userEnter);
        }
    }

    private void startGame(int entryCode){
        if(m_dicRoom.containsKey(entryCode)){
            m_dicRoom.get(entryCode).setEnumState(GameRoomInfo.roomState.started);
        }
    
    }
    
    private Map<Integer,GameRoomInfo> getGameRoom(){
        return m_dicRoom;
    }
    //private end
}
