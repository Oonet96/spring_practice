package com.example.demo.service;

import com.example.demo.repository.TestRepository;
import com.example.demo.dto.TestDto;
import com.example.demo.entity.Reviews;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;

@Service
@Component
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    private final int iEleCountPerPage = 1000;

    @Transactional(readOnly = true)
    public List<TestDto> testServiceMethod(int index){
        System.out.println("TestService : "+testRepository);
        System.out.println("TestService : "+testRepository.count());
       
        System.out.println("==================== testServiceMethod Start ======================");
        List<TestDto> lstTestDto = new ArrayList<TestDto>();
        
        int i = index*iEleCountPerPage;
        List<Integer> temp = new ArrayList<Integer>();
		for(int j = 0; j<iEleCountPerPage; j++){
            temp.add(i+j);
		}
    
        //Repo는 한번의 요청에 한번만 호출될 수 있도록 만들것!!
        //현재코드는 데이터베이스에서 데이터가 삭제될경우 빠진채로 보내고 있음
        //FindAll 다른기능사용해야됨
        List<Reviews> lstReview = testRepository.findAllById(temp);
        for(Reviews review : lstReview){
            
            if(review == null){
                System.out.println("Have no data! ID");
                continue;
            }

            long unixTimestamp = review.getTime();
            Instant instant = Instant.ofEpochSecond(unixTimestamp);
    
            // Instant를 LocalDate로 변환 (기본 시간대 사용)
            System.out.println("List Add");
            lstTestDto.add(new TestDto(
                review.getId(),review.getProductId(),review.getUserId(),review.getProfileName(),
                review.getHelpfulnessNumerator(),review.getHelpfulnessDenominator(),review.getScore(),
                instant.atZone(ZoneId.systemDefault()).toOffsetDateTime(),review.getSummary(),review.getText()
            ));
        }

        System.out.println("lstTestDto size : "+lstTestDto.size());
        System.out.println("==================== testServiceMethod End ======================");
        return lstTestDto;

    }
}
