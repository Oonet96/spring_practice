package com.example.demo.service.game;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.util.GameRoomData;
import com.example.demo.util.UserInGameData;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameRoomService {

    private Map<Integer,GameRoomData> m_dicRoom = new HashMap<Integer,GameRoomData>();

    protected void createGame(int entryCode,String userId,String roomText){
        
        Set<Integer> temp = m_dicRoom.keySet();
        Iterator<Integer> entryCodes = temp.iterator();

        while(entryCodes.hasNext()){
            if(entryCodes.next() == entryCode){
                System.out.println("[GameManagementService.createGame()] entryCodes.next() == entryCode!!");
                return;
            }
        }

        m_dicRoom.put(entryCode,new GameRoomData(entryCode, userId, roomText));
    }

    protected void joinGame(int entryCode,String userId){
        if(m_dicRoom.containsKey(entryCode)){
            m_dicRoom.get(entryCode).setUser2(new UserInGameData(userId));
            m_dicRoom.get(entryCode).setEnumState(GameRoomData.roomState.USERENTER);
        }
    }

    protected void startGame(int entryCode){
        if(m_dicRoom.containsKey(entryCode)){
            m_dicRoom.get(entryCode).setEnumState(GameRoomData.roomState.STARTED);
        }
    }

    protected Map<Integer,GameRoomData> getGameRoom(){
        return m_dicRoom;
    }
}
