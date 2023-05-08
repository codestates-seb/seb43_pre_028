package server.server.question.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import server.server.answer.dto.AnswerDto;
import server.server.question.dto.QuestionDto;
import server.server.question.entity.Question;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-24T15:03:34+0900",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.17 (Azul Systems, Inc.)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public Question questionPostToQuestion(QuestionDto.Post postQuestion) {
        if ( postQuestion == null ) {
            return null;
        }

        Question question = new Question();

        question.setTitle( postQuestion.getTitle() );
        question.setContentProblem( postQuestion.getContentProblem() );
        question.setContentTried( postQuestion.getContentTried() );

        return question;
    }

    @Override
    public Question questionPatchToQuestion(QuestionDto.Patch patchQuestion) {
        if ( patchQuestion == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionId( patchQuestion.getQuestionId() );
        question.setTitle( patchQuestion.getTitle() );
        question.setContentProblem( patchQuestion.getContentProblem() );
        question.setContentTried( patchQuestion.getContentTried() );

        return question;
    }

    @Override
    public QuestionDto.Response questionToResponseQuestion(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionDto.Response response = new QuestionDto.Response();

        if ( question.getQuestionId() != null ) {
            response.setQuestionId( question.getQuestionId() );
        }
        response.setTitle( question.getTitle() );
        response.setContentProblem( question.getContentProblem() );
        response.setContentTried( question.getContentTried() );
        response.setViewCount( question.getViewCount() );
        response.setQuestionVoteCount( question.getQuestionVoteCount() );
        response.setModifiedAt( question.getModifiedAt() );

        return response;
    }

    @Override
    public List<QuestionDto.Response> questionToQuestionResponse(List<Question> questions) {
        if ( questions == null ) {
            return null;
        }

        List<QuestionDto.Response> list = new ArrayList<QuestionDto.Response>( questions.size() );
        for ( Question question : questions ) {
            list.add( questionToResponseQuestion( question ) );
        }

        return list;
    }

    @Override
    public QuestionDto.AnswerResponse<AnswerDto.responseAnswer> responseToAnswerResponseDto(List<AnswerDto.responseAnswer> data, int answersCount) {
        if ( data == null ) {
            return null;
        }

        List<AnswerDto.responseAnswer> data1 = null;
        List<AnswerDto.responseAnswer> list = data;
        if ( list != null ) {
            data1 = new ArrayList<AnswerDto.responseAnswer>( list );
        }
        int answersCount1 = 0;
        answersCount1 = answersCount;

        QuestionDto.AnswerResponse<AnswerDto.responseAnswer> answerResponse = new QuestionDto.AnswerResponse<AnswerDto.responseAnswer>( data1, answersCount1 );

        return answerResponse;
    }
}
