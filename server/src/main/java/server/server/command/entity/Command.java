package server.server.command.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import server.server.answer.entity.Answer;
import server.server.user.entity.User;

import javax.persistence.Id;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "COMMAND")
public class Command  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commandId;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false, name = "UPDATED_AT")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "STATUS")
    private CommandStatus commandStatus = CommandStatus.COMMAND_EXIST;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String body;


    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public void addUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "ANSWER_ID")
    private Answer answer;

    public void addQuestion(Answer answer) {
        this.answer = answer;
    }

    public enum CommandStatus {
        COMMAND_NOT_EXIST("존재하지 않는 답변"),
        COMMAND_EXIST("존재하는 답변");

        @Getter
        private String status;

        CommandStatus(String status) {
            this.status = status;
        }
    }
}