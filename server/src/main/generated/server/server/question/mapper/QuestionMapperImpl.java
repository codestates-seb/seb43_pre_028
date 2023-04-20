package server.server.question.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import server.server.question.dto.QuestionDto;
import server.server.question.entity.Question;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-20T15:43:40+0900",
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
        response.setCreatedAt( question.getCreatedAt() );
        response.setModifiedAt( question.getModifiedAt() );
        response.setViews( question.getViews() );
        response.setVote( question.getVote() );

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
}
