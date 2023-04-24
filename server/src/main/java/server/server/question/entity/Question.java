package server.server.question.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Column(nullable = false)
    private LocalDateTime modifiedAt = LocalDateTime.now() ;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private int viewCount; //조회수 Count

    @OneToMany(mappedBy = "question") // 질문글과 답글은 일대 다
    private List<Answer> answers = new ArrayList<>();
    //멤버//
    private int questionVoteCount; //투표수카운트

    @OneToMany(mappedBy = "question")
    private List<QuestionVote> questionVotes = new ArrayList<>(); //투표


    //답변 개수 추가
    @Transient //컬럼에서 제거되기 위해 사용
    private int answerCount;

    @ManyToOne //회원과 질문들은 일대 다
    @JoinColumn(name = "user_id")
    private User user;

    public void setUser(User user) {

        this.user = user;
        if(!this.user.getQuestions().contains(this)){
            this.user.getQuestions().add(this);
        }
    }

    public void setAnswer(Answer answer){

        this.answers.add(answer);
        if(answer.getQuestion() != this){
            answer.setQuestion(this);
        }
    }

    public String getDisplayName(){
        return user.getDisplayName();
    }

    public long getUserId(){
        return user.getUserId();
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
