package com.example.demo.service.game;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@Component
@RequiredArgsConstructor
public class BaseballService {
	
    private void decideResult(int iBallNumber, Character offensePlayer, Character defendPlayer) {
		int[] iPlayerNumArr = getNumberArray(defendPlayer.getBallNumber());
		int[] iNumArr = getNumberArray(iBallNumber);
		int m_byCorrect = 0;
		
		for(int i = 0,j = 0; i<iPlayerNumArr.length;) {
			if(iPlayerNumArr[i] == iNumArr[j]) {
				//strike
				if(i == j) {
					m_byCorrect += 1 << i;
					//System.out.println("Strike! m_byCorrect : "+m_byCorrect+" i는 "+i);
				}
				//ball
				else {
					m_byCorrect += 1 << (i+(iPlayerNumArr.length));
					//System.out.println("Ball! m_byCorrect : "+m_byCorrect+" i는 "+i);
				}
				
			}

			j++;
			
			if(iPlayerNumArr.length <= j) {
				i++;
				j = 0;
			}

		}
		//System.out.println("BaseBallGame.decideResult() End!  m_byCorrect : "+m_byCorrect);
		//System.out.println("2진수 : "+Integer.toBinaryString(m_byCorrect));
		offensePlayer.setCorrect(m_byCorrect);
		offensePlayer.getResult();
	}
	
    //FrontEnd Code
	private int[] getNumberArray(int number) {
		int[] tempArr = new int[String.valueOf(number).length()];
		for(int i = 0; i<tempArr.length; i++) {
			tempArr[i] = number%10;
			number/=10;
		}
		
		return tempArr;
	}
}