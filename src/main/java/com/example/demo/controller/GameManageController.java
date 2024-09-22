package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.game.GameManagementService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GameManageController {

    private final GameManagementService gameService;
    
}
