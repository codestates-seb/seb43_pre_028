package server.server.answer.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import server.server.answer.dto.AnswerDto;
import server.server.answer.entity.Answer;
import server.server.question.entity.Question;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Mapper(componentModel = "spring")
public interface AnswerMapper {
    Answer answerPostToAnswer(AnswerDto.postAnswer postAnswer);
    Answer answerPatchToAnswer(AnswerDto.patchAnswer patch);
    AnswerDto.responseAnswer answerToAnswerResponse(Answer answer);
    List<AnswerDto.responseAnswer> answersToResponseAnswers(List<Answer> answers);
}
