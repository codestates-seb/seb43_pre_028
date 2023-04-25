package server.server.questionVote.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import server.server.question.dto.QuestionDto;
import server.server.question.entity.Question;
import server.server.questionVote.dto.QuestionVoteDto;
import server.server.questionVote.entity.QuestionVote;

@Mapper(componentModel = "spring")
public interface QuestionVoteMapper {
    @Mapping(source = "questionId", target = "question.questionId")
    QuestionVote questionVotePostQuestionVote(QuestionVoteDto.PostDto postQuestionVote);

    @Mapping(source = "question.questionId", target = "questionId")
    QuestionVoteDto.ResponseDto questionVoteToResponseQuestionVote(QuestionVote questionVote);
}
