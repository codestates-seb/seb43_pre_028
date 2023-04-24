package server.server.answervote.dto;

import lombok.*;

import java.time.LocalDateTime;

public class AnswerVoteDto {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VotePost{
        private long userId;
        private long answerId;
        private Boolean answerVoteStatus;
    }
    @Getter
    @Setter
    @AllArgsConstructor
    public static class VotePatch{
        private long userId;
        private long answerId;
        private Boolean answerVoteStatus;
    }
    @Getter
    @Builder
    public static class VoteResponse{
        private long answerVoteId;
        private long answerId;
        private long userId;
        private Boolean answerVoteStatus;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
    }
}
