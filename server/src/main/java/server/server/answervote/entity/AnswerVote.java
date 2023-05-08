package server.server.answervote.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import server.server.answer.entity.Answer;
import server.server.user.entity.User;

import javax.persistence.*;
    @Getter
    @Setter
    @Entity
    @NoArgsConstructor
    @Table(name = "ANSWERS_VOTE")
    public class AnswerVote {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long answerVoteId;

        @Column(nullable = false)
        private Boolean answerVoteStatus;  // defult == false

        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "ANSWER_ID")
        private Answer answer;

        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "USER_ID")
        private User user;
    }
