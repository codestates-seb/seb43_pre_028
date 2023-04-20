package server.server.command.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import server.server.answer.service.AnswerService;
import server.server.command.dto.CommandPatchDto;
import server.server.command.dto.CommandPostDto;
import server.server.command.entity.Command;
import server.server.command.mapper.CommandMapper;
import server.server.command.service.CommandService;
import server.server.dto.SingleResponseDto;
import server.server.user.mapper.UserMapper;
import server.server.user.service.UserService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/v1")
@Validated
@Slf4j
@AllArgsConstructor
public class CommandController {
    private CommandService commandService;
    private CommandMapper mapper;
    private UserService userService;
    private UserMapper userMapper;
    private AnswerService answerService;

//코멘트 작성 :댓글의 아이디와 코멘트의 내용을 받아와서 확인하고 정보 매핑해서 넘겨줌
    @PostMapping("/user/command/write")
    public ResponseEntity postCommand(@Valid @RequestBody CommandPostDto commandPostDto){//Dto->id,body
        //서비스는 사용할려고 전달, Dto는 값을 전달, 일단 오류가 없을 시 repo에 저장을 우선한 다음 command에 저장.
        Command command = commandService.createCommand(mapper.commandPostDtoToCommand(answerService,userService,commandPostDto));
        //매핑을 통해 CommandResponseDto 타입 (id, 상태, 등록시간, 수정시간, 내용, user) 정보를 전달
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.commandToCommandResponseDto(userMapper,command)), HttpStatus.CREATED);
    }
//코멘트 수정, 삭제 :
    @PatchMapping("/user/command/{command-id}")//id, Dto->id,body,상태
    public ResponseEntity patchCommand(@PathVariable("command-id") @Positive @NotNull long commandId,@Valid @RequestBody CommandPatchDto commandPatchDto){
        commandPatchDto.setCommandId(commandId);
        Command command = commandService.updateCommand(mapper.commandPatchDtoToCommand(commandService,userService,commandPatchDto));
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.commandToCommandResponseDto(userMapper,command)), HttpStatus.OK);
    }
}
