package server.server.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class AnswerDto {
    @Getter
    @Setter
    @AllArgsConstructor
    public static class postAnswer {
        private String content;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class patchAnswer {
        private long answerId;
        private String content;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class responseAnswer {
        private long answerId;
        private String content;

    }
}
