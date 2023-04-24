package server.server.answer.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import server.server.answer.dto.AnswerDto;
import server.server.answer.entity.Answer;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-24T15:03:35+0900",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.17 (Azul Systems, Inc.)"
)
@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public Answer answerPostToAnswer(long questionId, AnswerDto.postAnswer postAnswer) {
        if ( postAnswer == null ) {
            return null;
        }

        Answer answer = new Answer();

        if ( postAnswer != null ) {
            answer.setContent( postAnswer.getContent() );
        }

        return answer;
    }

    @Override
    public Answer answerPatchToAnswer(long questionId, AnswerDto.patchAnswer patchAnswer) {
        if ( patchAnswer == null ) {
            return null;
        }

        Answer answer = new Answer();

        if ( patchAnswer != null ) {
            answer.setAnswerId( patchAnswer.getAnswerId() );
            answer.setContent( patchAnswer.getContent() );
        }

        return answer;
    }

    @Override
    public AnswerDto.responseAnswer answerToResponseAnswer(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        AnswerDto.responseAnswer.responseAnswerBuilder responseAnswer = AnswerDto.responseAnswer.builder();

        responseAnswer.answerId( answer.getAnswerId() );
        responseAnswer.content( answer.getContent() );
        responseAnswer.votecount( answer.getVotecount() );
        responseAnswer.choose( answer.getChoose() );
        responseAnswer.createdAt( answer.getCreatedAt() );
        responseAnswer.modifiedAt( answer.getModifiedAt() );

        return responseAnswer.build();
    }

    @Override
    public List<AnswerDto.responseAnswer> answersToResponseAnswers(List<Answer> answers) {
        if ( answers == null ) {
            return null;
        }

        List<AnswerDto.responseAnswer> list = new ArrayList<AnswerDto.responseAnswer>( answers.size() );
        for ( Answer answer : answers ) {
            list.add( answerToResponseAnswer( answer ) );
        }

        return list;
    }
}
