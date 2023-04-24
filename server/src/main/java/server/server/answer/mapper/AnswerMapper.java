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
    //        default Answer answerPostToAnswer(long questionId, AnswerDto.postAnswer post){
//            Answer answer = new Answer();
//            answer.setContent(post.getContent());
//
//            Question question = new Question();
//            question.setQuestionId(questionId);
//            answer.setQuestion(question);
//
//            return answer;
//        }
//        Answer answerPatchToAnswer(long questionId, AnswerDto.patchAnswer patch);
//        AnswerDto.responseAnswer answerToAnswerResponse(Answer answer);
//        default List<AnswerDto.responseAnswer> answersToAnswerResponses(List<Answer> Answers){
//            List<AnswerDto.responseAnswer> responses = Answers.stream()
//                    .map(this::answerToAnswerResponse)
//                    .collect(Collectors.toList());
//
//            return responses;
//        }
    Answer answerPostToAnswer(long questionId, AnswerDto.postAnswer postAnswer);
    Answer answerPatchToAnswer(long questionId, AnswerDto.patchAnswer patchAnswer);
    AnswerDto.responseAnswer answerToResponseAnswer(Answer answer);
    List<AnswerDto.responseAnswer> answersToResponseAnswers(List<Answer> answers);
}
