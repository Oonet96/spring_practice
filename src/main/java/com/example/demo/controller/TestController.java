package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TestService;
import com.example.demo.dto.TestDto;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("Test")
public class TestController {

    private final TestService testService;

    @GetMapping("/{index}")
    public List<TestDto> test(@PathVariable int index) {
        System.out.println("TestController : "+index);
        List<TestDto> res = testService.testServiceMethod(index);
        System.out.println("return List<TestDto>!");
        return res;
    }

}
