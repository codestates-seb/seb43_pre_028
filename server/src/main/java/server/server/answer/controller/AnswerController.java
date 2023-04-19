package server.server.answer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import server.server.answer.dto.AnswerDto;
import server.server.answer.entity.Answer;
import server.server.answer.mapper.AnswerMapper;
import server.server.answer.service.AnswerService;
import server.server.dto.MultiResponseDto;
import server.server.dto.SingleResponseDto;
import server.server.utils.UriCreator;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/answers", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@Slf4j
public class AnswerController {
    private final static String ANSWER_DEFAULT_URL = "/answers";
    private final AnswerService answerService;
    private final AnswerMapper answerMapper;

    public AnswerController(AnswerService answerService, AnswerMapper answerMapper) {
        this.answerService = answerService;
        this.answerMapper = answerMapper;
    }

    // 201 create
    @PostMapping  // 생성
    public ResponseEntity postAnswer(@Valid @RequestBody AnswerDto.postAnswer postAnswer) {
        Answer answer = answerMapper.answerPostToAnswer(postAnswer);

        Answer response = answerService.createAnswer(answer);

        URI location = UriCreator.createUri(ANSWER_DEFAULT_URL, response.getAnswerId());

        return ResponseEntity.created(location).build();
    }

    // TODO 500 Internal Server Error
    @PatchMapping(value = "/{answer-id}", produces = "application/json")  // 수정
    public ResponseEntity patchAnswer(@PathVariable("answer-id") @Positive long answerId,
                                      @Valid @RequestBody AnswerDto.patchAnswer patchAnswer) {
        patchAnswer.setAnswerId(answerId);

        Answer response = answerService.updateAnswer(answerMapper.answerPatchToAnswer(patchAnswer));

        return new ResponseEntity<>(new SingleResponseDto<>(answerMapper.answerToResponseAnswer(response)), HttpStatus.OK);
    }

    // TODO 500 Internal Server Error
    @GetMapping(value = "/{answer-id}", produces = "application/json")  // 특정 아이디 조회
    public ResponseEntity getAnswer(@PathVariable("answer-id") @Positive long answerId) {
        Answer response = answerService.findAnswer(answerId);

        return new ResponseEntity<>(answerMapper.answerToResponseAnswer(response), HttpStatus.OK);
    }

    // TODO 400 Bad Request
    @GetMapping (produces = "application/json") // 모든 아이디 조회
    public ResponseEntity getAnswers(@Positive @RequestParam int page,
                                     @Positive @RequestParam int size) {
        Page<Answer> pageAnswers = answerService.findAnswers(page - 1, size);
        List<Answer> answers = pageAnswers.getContent();

        return new ResponseEntity<>(
                new MultiResponseDto<>(answerMapper.answersToResponseAnswers(answers),
                        pageAnswers),
                HttpStatus.OK);
    }

    // TODO 500 Internal Server Error
    @DeleteMapping(value = "/{answer-id}")  // 삭제
    public ResponseEntity deleteTodo(@PathVariable("answer-id") @Positive long answerId) {
        answerService.deleteAnswer(answerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}