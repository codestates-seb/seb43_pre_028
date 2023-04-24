package server.server.answer.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class AnswerDto {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class postAnswer {
        @NotBlank(message = "내용을 적어주세요.")
        private String content;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class patchAnswer {
        private long answerId;
        private long questionId;
        @NotBlank(message = "내용을 적어주세요.")
        private String content;
    }

    @Getter
    @Builder
    public static class responseAnswer {
        private long answerId;
        private long userId;
        private long questionId;
        private String content;
        private long votecount;
        private Boolean choose;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
    }
}
