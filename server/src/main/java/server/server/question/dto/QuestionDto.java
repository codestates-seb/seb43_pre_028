package server.server.question.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class QuestionDto {
    @Getter
    @Setter
    public static class Post{
        @NotBlank(message = "제목을 입력해주세요.")
        private String title;
        @NotBlank(message = "내용을 입력해주세요.")
        private String contentProblem;
        @NotBlank(message = "내용을 입력해주세요.")
        private String contentTried;
//        //멤버아이디
    }

    @Getter
    @Setter
    public static class Patch{
        private long questionId;
        private String title;
        private String contentProblem;
        private String contentTried;
    }

    @Getter
    @Setter
    public static class Response{
        private long questionId;
        private String title;
        private String contentProblem;
        private String contentTried;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        private int views;
        private int vote;
    }
}
