package server.server.answer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import server.server.answervote.entity.AnswerVote;
import server.server.question.entity.Question;
import server.server.user.entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ANSWERS")
public class Answer {
    public long getUserId() {
        return user.getUserId();
    }

    public String getUserName() {
        return user.getUserName();
    }

    public String getImage() {
        return user.getImage();
    }

    public long getQuestionId(){
        return question.getQuestionId();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long answerId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;  // 답변 내용

    @Column(nullable = false)
    private long votecount = 0;  // 투표 수

    @Column(nullable = false)
    private Boolean choose = false;  // 채택

    @Column
    private LocalDateTime createdAt = LocalDateTime.now();  // 작성 시간

    @Column(nullable = false, name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt = LocalDateTime.now();  // 수정 시간

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @JsonIgnore
    @OneToMany(mappedBy = "answer")
    private List<AnswerVote> answerVotes = new ArrayList<>();
}
