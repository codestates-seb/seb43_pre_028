package server.server.questionVote.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import server.server.audit.BaseEntity;
import server.server.question.entity.Question;
import server.server.user.entity.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class QuestionVote extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionVoteId;

    @Column(nullable = false)
    private Boolean questionVoteStatus;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID") //외래키를 매핑할 때 사용
    private Question question;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public void setQuestion(Question question) {
        this.question = question;
        if(!this.question.getQuestionVotes().contains(this)){
            this.question.getQuestionVotes().add(this);
        }
    }
    public void setUser(User user) {
        this.user = user;
    }
}
