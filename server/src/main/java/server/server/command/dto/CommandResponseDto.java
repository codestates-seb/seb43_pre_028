package server.server.command.dto;


import lombok.Getter;
import lombok.Setter;
import server.server.command.entity.Command;
import server.server.user.dto.UserResponseDto;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommandResponseDto {
    private long commandId;
    private Command.CommandStatus commandStatus;
    private String body;
    private UserResponseDto user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}