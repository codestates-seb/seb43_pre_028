package server.server.answer.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import preproject.answer.dto.AnswerDto;
import preproject.answer.entity.Answer;

@Component
@Mapper(componentModel = "spring")
public interface AnswerMapper {
    Answer answerPostToAnswer(AnswerDto.postAnswer postAnswer);
    Answer answerPatchToAnswer(AnswerDto.patchAnswer patchAnswer);
    AnswerDto.responseAnswer answerToResponseAnswer(Answer answer);
}
