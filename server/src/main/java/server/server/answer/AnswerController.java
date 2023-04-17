package server.server.answer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import preproject.answer.dto.AnswerDto;
import preproject.answer.entity.Answer;
import preproject.answer.mapper.AnswerMapper;
import preproject.answer.service.AnswerService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/answers")
@Validated
@Slf4j
// TODO Bean등록 에러 잡기
public class AnswerController {
    private final AnswerService answerService;
    private final AnswerMapper answerMapper;

    public AnswerController(AnswerService answerService, AnswerMapper answerMapper) {
        this.answerService = answerService;
        this.answerMapper = answerMapper;
    }

    @PostMapping  // 생성
    public ResponseEntity postAnswer(@Valid @RequestBody AnswerDto.postAnswer postAnswer) {
        Answer answer = answerMapper.answerPostToAnswer(postAnswer);


        Answer response = answerService.createAnswer(answer);

        return new ResponseEntity<>(answerMapper.answerToResponseAnswer(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{answer-id}")  // 수정
    public ResponseEntity patchAnswer(@PathVariable("answer-id") @Positive long answerId,
                                    @Valid @RequestBody AnswerDto.patchAnswer patchAnswer) {
        patchAnswer.setAnswerId(answerId);

        Answer response = answerService.updateAnswer(answerMapper.answerPatchToAnswer(patchAnswer));

        return new ResponseEntity<>(answerMapper.answerToResponseAnswer(response), HttpStatus.OK);
    }

    @GetMapping("/{answer-id}")  // 특정 아이디 조회
    public ResponseEntity getAnswer(@PathVariable("answer-id") @Positive long answerId) {
        Answer response = answerService.findAnswer(answerId);

        return new  ResponseEntity<>(answerMapper.answerToResponseAnswer(response), HttpStatus.OK);
    }

    @GetMapping  // 모든 아이디 조회
    public ResponseEntity getAnswers() {
        List<Answer> answers = answerService.findAnswers();

        List<AnswerDto.responseAnswer> response =
                answers.stream()
                        .map(answer -> answerMapper.answerToResponseAnswer(answer))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{answer-id}")  // 특정 아이디 삭제
    public ResponseEntity deleteTodo(@PathVariable("answer-id") @Positive long answerId) {
        System.out.println("# answerId : " + answerId);

        answerService.deleteAnswer(answerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
