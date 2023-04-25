package server.server.questionVote.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import server.server.question.entity.Question;
import server.server.questionVote.entity.QuestionVote;
import server.server.user.entity.User;

import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

public class QuestionVoteDto {

    @AllArgsConstructor
    @Getter
    @Setter
    @NoArgsConstructor
    public static class PostDto {
        private Boolean questionVoteStatus;

        private long userId;
        private long questionId;

        public void setQuestionId(long questionId) {
            this.questionId = questionId;
        }

        public User getUser() {
            User user = new User();
            user.setUserId(userId);

            return user;
        }

    }

    public static class PatchDto{

    }

    @AllArgsConstructor
    @Getter
    @Setter
    public static class ResponseDto{
        private long questionVoteId;
        private boolean questionVoteStatus;
        private long questionId;
        private long userId;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
    }
}
