package server.server.answer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import server.server.answer.dto.AnswerDto;
import server.server.answer.entity.Answer;
import server.server.answer.mapper.AnswerMapper;
import server.server.answer.service.AnswerService;
import server.server.dto.SingleResponseDto;
import server.server.question.dto.QuestionDto;
import server.server.question.entity.Question;
import server.server.utils.UriCreator;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@Slf4j
public class AnswerController {
    private final static String ANSWER_DEFAULT_URL = "/";
    private final AnswerService answerService;
    private final AnswerMapper answerMapper;

    public AnswerController(AnswerService answerService, AnswerMapper answerMapper) {
        this.answerService = answerService;
        this.answerMapper = answerMapper;
    }

    // 201 create
    @PostMapping("questions/{question-id}/answers")  // 생성
    public ResponseEntity postAnswer(@PathVariable("question-id") long questionId,
                                     @Valid @RequestBody AnswerDto.postAnswer postAnswer) {
        Answer answer = answerMapper.answerPostToAnswer(questionId, postAnswer);

        Answer response = answerService.createAnswer(answer);

//        Answer response = answerService.createAnswer(answerMapper.answerPostToAnswer(questionId, postAnswer));

        URI location = UriCreator.createUri(ANSWER_DEFAULT_URL, response.getAnswerId());

//        return ResponseEntity.created(location).build();
        return new ResponseEntity<>(new SingleResponseDto<>(location), HttpStatus.CREATED);
    }



    // 200 OK
    @PatchMapping(value = "questions/{question-id}/answers/{answer-id}", produces = "application/json")  // 수정
    public ResponseEntity patchAnswer(@PathVariable("question-id") @Positive long questionId,
                                      @PathVariable("answer-id") @Positive long answerId,
                                      @Valid @RequestBody AnswerDto.patchAnswer patchAnswer) {
        patchAnswer.setAnswerId(answerId);

//        Answer answer = answerMapper.answerPatchToAnswer(patchAnswer);
        Answer answer = answerService.updateAnswer(answerMapper.answerPatchToAnswer(questionId, patchAnswer));

        return new ResponseEntity<>(new SingleResponseDto<>(answer), HttpStatus.OK);
    }

    // 200 OK
    @GetMapping(value = "answers", produces = "application/json") // 모든 답변 조회
    public ResponseEntity getAnswers() {
        List<Answer> answers = answerService.findAnswers();

        return new ResponseEntity<>(new SingleResponseDto<>(answers),  HttpStatus.OK);
    }

    // 204 No Content
    @DeleteMapping(value = "questions/{question-id}/answers/{answer-id}")  // 삭제
    public ResponseEntity deleteAnswer(@PathVariable("answer-id") @Positive long answerId) {
        answerService.deleteAnswer(answerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}