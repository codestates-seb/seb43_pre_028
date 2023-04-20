package server.server.question.mapper;

import org.mapstruct.Mapper;
import server.server.question.dto.QuestionDto;
import server.server.question.entity.Question;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question questionPostToQuestion(QuestionDto.Post postQuestion);
    Question questionPatchToQuestion(QuestionDto.Patch patchQuestion);
    QuestionDto.Response questionToResponseQuestion(Question question);
    List<QuestionDto.Response> questionToQuestionResponse(List<Question> questions);

}
