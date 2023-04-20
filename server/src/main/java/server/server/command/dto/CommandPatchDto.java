package server.server.command.dto;
import lombok.Getter;
import lombok.Setter;
import server.server.command.entity.Command;

@Getter
public class CommandPatchDto {
    @Setter
    private long commandId;

    private String body;

    private Command.CommandStatus commandStatus;
}