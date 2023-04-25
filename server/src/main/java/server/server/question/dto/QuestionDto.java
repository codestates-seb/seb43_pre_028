package server.server.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import server.server.answer.dto.AnswerDto;
import server.server.user.entity.User;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionDto {
    @Getter
    @Setter
    public static class Post{
        @NotBlank(message = "제목을 입력해주세요.")
        private String title;
//        @NotBlank(message = "내용을 입력해주세요.")
//        private Map<String, String> content = new HashMap<>();

        @NotBlank(message = "문제점을 입력해주세요.")
        private String problem;
        @NotBlank(message = "해결했던 방안을 입력해주세요.")
        private String tried;

        @Positive
        private long userId;

        public User getUser() {
            User user = new User();
            user.setUserId(userId);

            return user;
        }
//        public void setContent(String problem, String tried) {
//            content.put("problem", problem);
//            content.put("tried", tried);
//            this.content = content;
//        }

    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch{
        private long questionId;
        private String title;
//        private Map<String, String> content = new HashMap<>();
        private String problem;
        private String tried;

        public void setQuestionId(long questionId) {
            this.questionId = questionId;
        }

//        public void setContent(String problem, String tried) {
//            content.put("problem", problem);
//            content.put("tried", tried);
//            this.content = content;
//        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response{
        private  long userId;
        private long questionId;
        private String title;
//        private Map<String, String> content = new HashMap<>();
        private String problem;
        private String tried;
        private int views;
        private int questionVoteCount;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        private String image;
        private String userName;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class AnswerResponse<T>{
        private List<T> data;
        int answersCount;
    }
}
