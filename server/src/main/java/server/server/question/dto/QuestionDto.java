package server.server.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import server.server.answer.dto.AnswerDto;
import server.server.user.entity.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;

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

    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch{
        private long questionId;
        private String title;
        private String contentProblem;
        private String contentTried;

        public void setQuestionId(long questionId) {
            this.questionId = questionId;
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response{
        private long questionId;
        private String title;
        private String contentProblem;
        private String contentTried;
        private int viewCount;
        private int questionVoteCount;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class AnswerResponse<T>{
        private List<T> data;
        int answersCount;
    }
}
