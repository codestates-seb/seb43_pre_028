package server.server.command.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import server.server.answer.entity.Answer;
import server.server.command.entity.Command;
import server.server.command.repository.CommandRepository;
import server.server.exception.BusinessLogicException;
import server.server.exception.ExceptionCode;
import server.server.user.entity.User;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommandService {
    private final CommandRepository commandRepository;

    public CommandService(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    public Command createCommand(Command command){
        return commandRepository.save(command);
    }

    public Command findVerifiedCommand(long commandId){ //요청된 답이 DB에 없으면 에러
        Optional<Command> optionalCommand = commandRepository.findById(commandId);
        Command findCommand = optionalCommand.orElseThrow(()->
                new BusinessLogicException(ExceptionCode.COMMAND_NOT_FOUND));
        return findCommand;
    }
    public User findCommandUser(long commandId){
        Command findCommand = findVerifiedCommand(commandId); //요청된 답이 DB에 없으면 에러
        return findCommand.getUser();
    }
    public Page<Command> findCommand(Answer answer, int commandPage, int commandSize, String commandSort) throws BusinessLogicException{
        Page<Command> findAllCommand = commandRepository.finaAllByAnswerAndCommandStatus( //해당question의 삭제되지 않은 answer의 Page를 가져온다
                PageRequest.of(commandPage-1,commandSize, Sort.by(commandSort).descending()),
                answer, Command.CommandStatus.COMMAND_EXIST);
        VerifiedNoCommand(findAllCommand);

        return findAllCommand;
    }
    public Command updateCommand(Command command){
        Command findCommand = findVerifiedCommand(command.getCommandId());//요청된 답이 DB에 없으면 에러

        Optional.ofNullable(command.getBody()) //내용수정
                .ifPresent(commandBody->findCommand.setBody(commandBody));

        Optional.ofNullable(command.getUpdatedAt()) // 업데이트 날짜 수정
                .ifPresent(commandUpdatedAt->findCommand.setUpdatedAt(commandUpdatedAt));


        Optional.ofNullable(command.getCommandStatus()) //글 삭제
                .ifPresent(commandStatus->findCommand.setCommandStatus(commandStatus));

        Command updatedQuestion = commandRepository.save(findCommand);

        return updatedQuestion;
    }
    private void VerifiedNoCommand(Page<Command> findAllCommand) throws BusinessLogicException{//status가 ANSWER_EXIST인 List 데이터가 0이면 예외발생
        if(findAllCommand.getTotalElements()==0){
            throw new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND);
        }
    }

}
