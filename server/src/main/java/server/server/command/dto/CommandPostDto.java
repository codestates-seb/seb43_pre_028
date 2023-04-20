package server.server.command.dto;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
public class CommandPostDto {
    @Positive
    @NotNull
    private Long AnswerId;

    @NotBlank
    private String body;
}