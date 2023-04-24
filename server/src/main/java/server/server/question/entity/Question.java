package server.server.question.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import server.server.answer.entity.Answer;
import server.server.answer.entity.Answer;
import server.server.question.audit.QuestionAuditable;
import server.server.questionVote.entity.QuestionVote;
import server.server.user.entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Question extends QuestionAuditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(nullable = false, length = 1000)
    private String title;

    @Column(nullable = false, length = 5000)
    private String contentProblem;

    @Column(nullable = false, length = 5000)
    private String contentTried;

    @Column(nullable = false)
    private LocalDateTime modifiedAt = LocalDateTime.now() ;

    @Column(nullable = false)
    private int viewCount;

    @Column(nullable = false)
    private int vote;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();
    //멤버//
    private int questionVoteCount;

    @OneToMany(mappedBy = "question")
    private List<QuestionVote> questionVotes = new ArrayList<>();


    //답변 개수 추가
    @Transient //컬럼에서 제거되기 위해 사용
    private int answerCount;

    @ManyToOne //회원과 질문들은 일대 다
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "question") // 질문글과 답글은 일대 다
    private List<Answer> answers = new ArrayList<>();

    public void setUser(User user) {
        this.user = user;
    }

    public void setAnswer(Answer answer){
        this.answers.add(answer);
    }

    public void setQuestionVotes(List<QuestionVote> questionVotes) {
        this.questionVotes = questionVotes;
    }

    public int getAnswerCount() {
        answerCount = answers.size();
        return answerCount;
    }

    public int getQuestionVoteCount() {
        questionVoteCount = questionVotes.stream()
                .mapToInt(questionVote -> questionVote.getQuestionVoteStatus() ? 1 : -1)
                .sum();
        return questionVoteCount;
    }

    public void addViewCount() {
        this.viewCount++;
    }

    public void setQuestionVote(QuestionVote questionVote) {
        this.questionVotes.add(questionVote);
        if(questionVote.getQuestion() != this){
            questionVote.setQuestion(this);
        }
    }
}
