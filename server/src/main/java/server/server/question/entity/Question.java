package com.codestates.server.question.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    @Column(nullable = false, length = 1000)
    private String title;
    @Column(nullable = false, length = 5000)
    private String contentProblem;
    @Column(nullable = false, length = 5000)
    private String contentTried;
    @CreatedDate
    @Column
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt ;
    @Column(nullable = false)
    private int views;
    private int vote;
    //멤버

    //답변
}
