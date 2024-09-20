package com.example.demo.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//     Id INT PRIMARY KEY,
//     ProductId VARCHAR(50),
//     UserId VARCHAR(50),
//     ProfileName VARCHAR(100),
//     HelpfulnessNumerator INT,
//     HelpfulnessDenominator INT,
//     Score INT,
//     Time BIGINT,
//     Summary VARCHAR(255),
//     Text TEXT

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(length = 50, name="ProductId")
    private String productId;

    @Column(length = 50, name="UserId")
    private String userId;

    @Column(length = 100, name="ProfileName")
    private String profileName;

    @Column(name="HelpfulnessNumerator")
    private Integer helpfulnessNumerator;

    @Column(name="HelpfulnessDenominator")
    private Integer helpfulnessDenominator;

    @Column
    private Integer score;

    @Column
    private Integer time;

    @Column(length = 255)
    private String summary;

    @Column
    private String text;

    @Builder
    public Reviews(Integer id,String productId, String userId, String profileName, 
    Integer helpfulnessNumerator, Integer helpfulnessDenominator, Integer score, Integer time, String summary, String text)
    {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.profileName = profileName;
        this.helpfulnessNumerator = helpfulnessNumerator;
        this.helpfulnessDenominator = helpfulnessDenominator;
        this.score = score;
        this.time = time;
        this.summary = summary;
        this.text = text;
    }
}

    