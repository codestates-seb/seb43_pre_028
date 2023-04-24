package server.server.questionVote.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import server.server.questionVote.entity.QuestionVote;

import java.time.LocalDateTime;

public class QuestionVoteDto {

    @AllArgsConstructor
    @Getter
    public static class PostDto {
        private Boolean questionVoteStatus;
        private long questionId;

        public void setQuestionId(long questionId) {
            this.questionId = questionId;
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
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
    }
}
