package server.server.question.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import server.server.answer.entity.Answer;

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

    @Column
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false, name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt = LocalDateTime.now() ;

    @Column(nullable = false)
    private int views;

    @Column(nullable = false)
    private int vote;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();
    //멤버//

    //답변
}
