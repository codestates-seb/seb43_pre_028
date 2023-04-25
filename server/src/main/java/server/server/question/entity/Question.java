package server.server.question.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import server.server.answer.entity.Answer;
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
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(nullable = false, length = 1000)
    private String title;

    @Column(nullable = false, length = 5000)
    private String problem;

    @Column(nullable = false, length = 5000)
    private String tried;

    @Column(nullable = false)
    private LocalDateTime modifiedAt = LocalDateTime.now() ;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private int views; //조회수

    @JsonIgnore
    @OneToMany(mappedBy = "question")
    private List<QuestionVote> vote = new ArrayList<>(); //투표

    @Column(nullable = false)
    private int votes; //투표 카운트

    @JsonIgnore
    @OneToMany(mappedBy = "question") // 질문글과 답글은 일대 다
    private List<Answer> answers = new ArrayList<>();

    //답변 개수 추가
    @Transient //컬럼에서 제거되기 위해 사용
    private int answerCount;

    @JsonIgnore
    @ManyToOne //회원과 질문들은 일대 다
    @JoinColumn(name = "user_id")
    private User user;

    //회원 닉네임 가져오기
    public String getUserName(){
        return user.getUserName();
    }

    //회원 회원id 가져오기
    public long getUserId(){
        return user.getUserId();
    }

    //회원 이미지 가져오기
    public String getImage() {
        return user.getImage();
    }

    //질문 개수 가져오기
    public int getAnswerCount(){
        answerCount = answers.size();
        return answerCount;
    }

    //투표 개수 가져오기
    public int getVotes() {
        votes = vote.stream()
                .mapToInt(questionVote -> questionVote.getQuestionVoteStatus() ? 1 : -1)
                .sum();
        return votes;
    }

    //댓글 정보 가져오기
    public void setAnswer(Answer answer){

        this.answers.add(answer);
        if(answer.getQuestion() != this){
            answer.setQuestion(this);
        }
    }

    //유저 정보 가져오기
    public void setUser(User user) {

        this.user = user;
        if(!this.user.getQuestions().contains(this)){
            this.user.getQuestions().add(this);
        }
    }

    //투표 가져오기
    public void setVotes(QuestionVote votes) {
        this.vote.add(votes);
        if(votes.getQuestion() != this){
            votes.setQuestion(this);
        }
    }

    // 조회수 증가해서 가져오기
    public void addViews(){
        this.views++;
    }

}
