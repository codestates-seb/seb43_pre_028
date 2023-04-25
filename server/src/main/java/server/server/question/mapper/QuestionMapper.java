package server.server.question.mapper;

import org.mapstruct.Mapper;
import server.server.answer.dto.AnswerDto;
import server.server.question.dto.QuestionDto;
import server.server.question.entity.Question;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question postDtoToQuestion(QuestionDto.Post postQuestion);
    Question patchDtoToQuestion(QuestionDto.Patch patchQuestion);
    QuestionDto.Response questionToResponseDto(Question question);
    List<QuestionDto.Response> questionToResponseDtos(List<Question> questions);

    QuestionDto.AnswerResponse<AnswerDto.responseAnswer> responseToAnswerResponseDto
            (List<AnswerDto.responseAnswer> data, int answersCount);

}
