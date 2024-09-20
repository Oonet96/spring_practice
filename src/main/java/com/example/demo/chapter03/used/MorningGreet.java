package com.example.demo.chapter03.used;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class MorningGreet implements Greet {

    @Override
    public void greeting(){
        System.out.println("-----------------------");
        System.out.println("좋은 아침입니다.");
        System.out.println("-----------------------");
    }
}
