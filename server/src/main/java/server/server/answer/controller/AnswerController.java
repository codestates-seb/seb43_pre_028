package server.server.answer.controller;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
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
import java.util.ArrayList;
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

//    // 200 OK
//    @GetMapping(value = "answers", produces = "application/json") // 모든 답변 조회
////    @GetMapping("{question-id}/answers")  // 해당 질문에 관한 모든 답변 조회
//    public ResponseEntity getAnswers() {
//        List<Answer> answers = answerService.findAnswers();
//
//        return new ResponseEntity<>(new SingleResponseDto<>(answers),  HttpStatus.OK);
//    }

    @GetMapping("answers")
    public ResponseEntity getAnswer() {

        JSONObject answerJson1 = new JSONObject();
        answerJson1.put("answerId", 1);
        answerJson1.put("questionId", 1);
        answerJson1.put("content", "경아님 매력있어");
        answerJson1.put("votes", 0);
        answerJson1.put("userName", "눈물 주루룩");
        answerJson1.put("userImage", "https://i.pravatar.cc");
        answerJson1.put("createdAt", "2023-04-26 05:18:11");
        answerJson1.put("modifiedAt", "2023-04-26 05:18:11");

        JSONObject answerJson2 = new JSONObject();
        answerJson2.put("answerId", 2);
        answerJson1.put("questionId", 1);
        answerJson2.put("content", "경아님 너무 좋아");
        answerJson2.put("votes", 0);
        answerJson2.put("userName", "눈물 주루룩");
        answerJson2.put("userImage", "https://i.pravatar.cc");
        answerJson2.put("createdAt", "2023-04-26 05:18:11");
        answerJson2.put("modifiedAt", "2023-04-26 05:18:11");

        JSONObject answerJson3 = new JSONObject();
        answerJson3.put("answerId", 3);
        answerJson3.put("questionId", 1);
        answerJson3.put("content", "경아님 매력있어");
        answerJson3.put("votes", 0);
        answerJson3.put("userName", "눈물 주루룩");
        answerJson3.put("userImage", "https://i.pravatar.cc");
        answerJson3.put("createdAt", "2023-04-26 05:18:11");
        answerJson3.put("modifiedAt", "2023-04-26 05:18:11");

        JSONObject answerJson4 = new JSONObject();
        answerJson4.put("answerId", 4);
        answerJson3.put("questionId", 2);
        answerJson4.put("content", "경아님 매력있어");
        answerJson4.put("votes", 0);
        answerJson4.put("userName", "눈물 주루룩");
        answerJson4.put("userImage", "https://i.pravatar.cc");
        answerJson4.put("createdAt", "2023-04-26 05:18:11");
        answerJson4.put("modifiedAt", "2023-04-26 05:18:11");

        JSONObject answerJson5 = new JSONObject();
        answerJson5.put("answerId", 5);
        answerJson5.put("questionId", 3);
        answerJson5.put("content", "경아님 매력있어");
        answerJson5.put("votes", 0);
        answerJson5.put("userName", "눈물 주루룩");
        answerJson5.put("userImage", "https://i.pravatar.cc");
        answerJson5.put("createdAt", "2023-04-26 05:18:11");
        answerJson5.put("modifiedAt", "2023-04-26 05:18:11");

        ArrayList<JSONObject> answerJson = new ArrayList<>();

        answerJson.add(answerJson1);
        answerJson.add(answerJson2);
        answerJson.add(answerJson3);
        answerJson.add(answerJson4);
        answerJson.add(answerJson5);


        return new ResponseEntity<>((answerJson), HttpStatus.OK);
    }

    // 204 No Content
    @DeleteMapping("answers/{answer-id}")  // 삭제
    public ResponseEntity deleteAnswer(@PathVariable("answer-id") @Positive long answerId) {
        answerService.deleteAnswer(answerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}