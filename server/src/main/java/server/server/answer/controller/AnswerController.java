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

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@Slf4j
public class AnswerController {
    private final AnswerService answerService;
    private final AnswerMapper answerMapper;

    public AnswerController(AnswerService answerService, AnswerMapper answerMapper) {
        this.answerService = answerService;
        this.answerMapper = answerMapper;
    }

    // 201 create
    @PostMapping("answers")  // 생성
    public ResponseEntity postAnswer(@Valid @RequestBody AnswerDto.postAnswer postAnswer) {
        Answer answer = answerMapper.answerPostToAnswer(postAnswer);

        Answer response = answerService.createAnswer(answer);

        return new ResponseEntity<>(new SingleResponseDto<>(answerMapper.answerToAnswerResponse(response)), HttpStatus.CREATED);
    }

    // 200 OK
    @PatchMapping(value = "answers/{answer-id}", produces = "application/json")  // 수정
    public ResponseEntity patchAnswer(@PathVariable("answer-id") @Positive long answerId,
                                      @Valid @RequestBody AnswerDto.patchAnswer patchAnswer) {
        patchAnswer.setAnswerId(answerId);

        Answer answer = answerService.updateAnswer(answerMapper.answerPatchToAnswer(patchAnswer));

        return new ResponseEntity<>(new SingleResponseDto<>(answerMapper.answerToAnswerResponse(answer)), HttpStatus.OK);
    }

    // 200 OK
    @GetMapping(value = "answers", produces = "application/json") // 모든 답변 조회
//    @GetMapping("{question-id}/answers")  // 해당 질문에 관한 모든 답변 조회
    public ResponseEntity getAnswers() {
        List<Answer> answers = answerService.findAnswers();

        return new ResponseEntity<>(new SingleResponseDto<>(answers),  HttpStatus.OK);
    }

    // 204 No Content
    @DeleteMapping("answers/{answer-id}")  // 삭제
    public ResponseEntity deleteAnswer(@PathVariable("answer-id") @Positive long answerId) {
        answerService.deleteAnswer(answerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}