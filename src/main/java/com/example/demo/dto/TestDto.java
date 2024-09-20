package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
@AllArgsConstructor
public class TestDto {

    private Integer id;

    private String productId;

    private String userId;

    private String profileName;

    private Integer helpfulnessNumerator;

    private Integer helpfulnessDenominator;

    private Integer score;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private OffsetDateTime time;

    private String summary;

    private String text;
}