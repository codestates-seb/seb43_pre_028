package server.server.question.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import server.server.answer.mapper.AnswerMapper;
import server.server.dto.MultiResponseDto;
import server.server.dto.SingleResponseDto;
import server.server.question.dto.QuestionDto;
import server.server.question.entity.Question;
import server.server.question.mapper.QuestionMapper;
import server.server.question.service.QuestionService;
import server.server.utils.UriCreator;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;
@CrossOrigin
@RestController
@Slf4j
@Validated
@RequestMapping("/questions")
public class QuestionController {
    private final static String QUESTION_DEFAULT_URL = "/questions";
    private final QuestionService questionService;
    private final QuestionMapper mapper;
    private final AnswerMapper answerMapper;

    public QuestionController(QuestionService questionService,
                              QuestionMapper mapper,
                              AnswerMapper answerMapper) {
        this.questionService = questionService;
        this.mapper = mapper;
        this.answerMapper = answerMapper;
    }

    // 질문 생성
    @PostMapping
    public ResponseEntity postQuestion(@Valid @RequestBody QuestionDto.Post postQuestion){

        Question question = mapper.questionPostToQuestion(postQuestion);

        Question response = questionService.creteQuestion(question);

        URI location = UriCreator.createUri(QUESTION_DEFAULT_URL, response.getQuestionId());

        return ResponseEntity.created(location).build();
    }

    //질문 수정
    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion(@PathVariable("question-id") @Positive long questionId,
                                        @Valid @RequestBody QuestionDto.Patch patchQuestion){

        patchQuestion.setQuestionId(questionId);

        Question question = questionService.updateQuestion(mapper.questionPatchToQuestion(patchQuestion));
        QuestionDto.Response response = mapper.questionToResponseQuestion(question);

        URI location = UriCreator.createUri(QUESTION_DEFAULT_URL, question.getQuestionId());

        return ResponseEntity.status(HttpStatus.OK).location(location).body(response);
    }

    // 질문 조회(한 개만 선택)
    @GetMapping("/{question-id}")
    public ResponseEntity getQuestion(@PathVariable("question-id") @Positive long questionId){
        Question question = questionService.findQuestion(questionId);

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.questionToResponseQuestion(question)), HttpStatus.OK);
    }

    //질문 전체 조회
    @GetMapping
    public ResponseEntity getQuestions(@Positive @RequestParam(value = "page") int page, //, defaultValue = "1"
                                       @Positive @RequestParam(value = "size") int size) {
        Page<Question> pageQuestions= questionService.findQuestions(page-1, size);
        List<Question> questions = pageQuestions.getContent();

        return new ResponseEntity<>(new MultiResponseDto<>(mapper.questionToQuestionResponse(questions), pageQuestions), HttpStatus.OK);
    }

    //질문 삭제
    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") @Positive long questionId){
        questionService.deleteQuestion(questionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}