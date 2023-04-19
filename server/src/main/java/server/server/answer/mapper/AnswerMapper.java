package server.server.answer.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import server.server.answer.dto.AnswerDto;
import server.server.answer.entity.Answer;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AnswerMapper {
    Answer answerPostToAnswer(AnswerDto.postAnswer postAnswer);
    Answer answerPatchToAnswer(AnswerDto.patchAnswer patchAnswer);
    AnswerDto.responseAnswer answerToResponseAnswer(Answer answer);
    List<AnswerDto.responseAnswer> answersToResponseAnswers(List<Answer> answers);
}
