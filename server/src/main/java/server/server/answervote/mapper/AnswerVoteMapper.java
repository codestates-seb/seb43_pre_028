package server.server.answervote.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import server.server.answervote.dto.AnswerVoteDto;
import server.server.answervote.entity.AnswerVote;

@Mapper(componentModel = "spring")
public interface AnswerVoteMapper {
    @Mapping(source = "answerId", target = "answer.answerId")
    AnswerVote postDtoToAnswerVote(AnswerVoteDto.VotePost post);

    @Mapping(source = "answer.answerId", target = "answerId")
    AnswerVoteDto.VoteResponse answerVoteToResponseDto(AnswerVote answerVote);
}
