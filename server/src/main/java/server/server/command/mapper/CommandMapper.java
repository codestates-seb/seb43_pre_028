package server.server.command.mapper;
import org.mapstruct.Mapper;
import server.server.answer.service.AnswerService;
import server.server.command.dto.CommandPatchDto;
import server.server.command.dto.CommandPostDto;
import server.server.command.dto.CommandResponseDto;
import server.server.command.entity.Command;
import server.server.command.service.CommandService;
import server.server.exception.BusinessLogicException;
import server.server.exception.ExceptionCode;
import server.server.user.entity.User;
import server.server.user.mapper.UserMapper;
import server.server.user.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "Spring")
public interface CommandMapper {

    default Command commandPostDtoToCommand(AnswerService answerService, UserService userService, CommandPostDto commandPostDto){//사용
        Command command = new Command();//commandid,등록날짜,수정날짜,상태,body,user,answerid
        command.setBody(commandPostDto.getBody()); //내용
        command.setAnswer(answerService.findVerifiedAnswer(commandPostDto.getAnswerId())); //ans설정
        command.setUser(userService.getLoginUser());//user설정

        return command;
    }
    default Command commandPatchDtoToCommand(CommandService commandService, UserService userService, CommandPatchDto commandPatchDto) {
        if (userService.getLoginUser().getUserId() != commandService.findCommandUser(commandPatchDto.getCommandId()).getUserId()) {
            throw new BusinessLogicException(ExceptionCode.ACCESS_DENIED_USER);
        }
        Command command = new Command();
        command.setCommandId(commandPatchDto.getCommandId());
        command.setBody(commandPatchDto.getBody());
        command.setCommandStatus(commandPatchDto.getCommandStatus());

        return command;
    }
    default CommandResponseDto commandToCommandResponseDto(UserMapper userMapper, Command command){
        CommandResponseDto commandResponseDto = new CommandResponseDto();
        commandResponseDto.setCommandId(command.getCommandId());
        commandResponseDto.setCommandStatus(command.getCommandStatus());
        commandResponseDto.setBody(command.getBody());
        commandResponseDto.setCreatedAt(command.getCreatedAt());

        User user = command.getUser();
        commandResponseDto.setUser(userMapper.userToUserResponseDto(user));
        commandResponseDto.setUpdatedAt(command.getUpdatedAt());

        return commandResponseDto;
    }
    List<CommandResponseDto> commandsToCommandResponseDtos(List<Command> commands);
}
