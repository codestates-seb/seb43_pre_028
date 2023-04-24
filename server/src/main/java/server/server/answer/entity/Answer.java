package server.server.answer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import server.server.question.entity.Question;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long answerId;

    @Column(nullable = false)
    private String content;  // 답변 내용

    @Column
    private LocalDateTime createdAt = LocalDateTime.now();  // 작성 시간

    @Column(nullable = false, name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt = LocalDateTime.now();  // 수정 시간

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
