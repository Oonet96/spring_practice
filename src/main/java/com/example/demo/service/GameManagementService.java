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
    public class GameRoomInfo{
        private int entryCode = 0;
        private int playerNo1 = 0;

        @Setter
        private int playerNo2 = 0;
        
        private String roomText = null;

        @Setter
        private boolean isEnd = false;

        public GameRoomInfo(int entryCode,int player1, String roomText){
            this.entryCode = entryCode;
            this.playerNo1 = player1;
            this.playerNo2 = 0;
            this.roomText = roomText;
            this.isEnd = false;
        }
    }

    Map<Integer,GameRoomInfo> m_dicRoom = new HashMap<Integer,GameRoomInfo>();

    //Public
    public Map<Integer,GameRoomInfo> CreateGame(int entryCode,int userNo,String roomText){
        
        createGame(entryCode,userNo,roomText);
        
        return getGameRoom();
    }

    public void JoinGame(int entryCode,int userNo){
        joinGame(entryCode,userNo);
    }

    public Map<Integer,GameRoomInfo> GetGameRoom(){
       return getGameRoom();
    }

    public void EndGame(int entryCode){

    }

    public void GetGameState(int entryCode){

    }
    //Public End

    //private
    private void createGame(int entryCode,int userNo,String roomText){
        
        Set<Integer> temp = m_dicRoom.keySet();
        Iterator<Integer> entryCodes = temp.iterator();

        while(entryCodes.hasNext()){
            if(entryCodes.next() == entryCode){
                System.out.println("[GameManagementService.createGame()] entryCodes.next() == entryCode!!");
                return;
            }
        }

        m_dicRoom.put(entryCode,new GameRoomInfo(entryCode, userNo, roomText));
    }

    private Map<Integer,GameRoomInfo> getGameRoom(){
        return m_dicRoom;
    }

    private void joinGame(int entryCode,int userNo){
        if(m_dicRoom.containsKey(entryCode))
            m_dicRoom.get(entryCode).setPlayerNo2(userNo);
    }
    //private end
}
