package server.server.question.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import server.server.answer.dto.AnswerDto;
import server.server.answer.mapper.AnswerMapper;
import server.server.dto.SingleResponse;
import server.server.dto.SingleResponseDto;
import server.server.question.dto.QuestionDto;
import server.server.question.entity.Question;
import server.server.question.mapper.QuestionMapper;
import server.server.question.service.QuestionService;
import server.server.user.service.UserService;
import server.server.utils.UriCreator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;
@CrossOrigin
@RestController
@Slf4j
@Validated
@RequestMapping(value = "/questions", produces = {MediaType.APPLICATION_JSON_VALUE})
public class QuestionController {
    private final static String QUESTION_DEFAULT_URL = "/questions";
    private final QuestionService questionService;
    private final QuestionMapper mapper;
    private final AnswerMapper answerMapper;
    private final UserService userService;

    public QuestionController(QuestionService questionService, QuestionMapper mapper, AnswerMapper answerMapper, UserService userService) {
        this.questionService = questionService;
        this.mapper = mapper;
        this.answerMapper = answerMapper;
        this.userService = userService;
    }

    // 질문 생성
    @PostMapping
    public ResponseEntity postQuestion(@Valid @RequestBody QuestionDto.Post postQuestion){
        Question question = mapper.postDtoToQuestion(postQuestion);
        Question createdQuestion = questionService.creteQuestion(question);


        return new ResponseEntity<>(new SingleResponseDto<>(mapper.questionToResponseDto(createdQuestion)), HttpStatus.CREATED);
    }

    //질문 수정
    @PatchMapping(value = "/{question-id}")
    public ResponseEntity patchQuestion(@PathVariable("question-id") @Positive long questionId,
                                        @Valid @RequestBody QuestionDto.Patch patchQuestion){

        patchQuestion.setQuestionId(questionId);

        Question question = questionService.updateQuestion(mapper.patchDtoToQuestion(patchQuestion));
        QuestionDto.Response response = mapper.questionToResponseDto(question);

        URI location = UriCreator.createUri(QUESTION_DEFAULT_URL, question.getQuestionId());

        //return ResponseEntity.status(HttpStatus.OK).location(location).body(response);
        return new ResponseEntity<>(new SingleResponseDto<>(location), HttpStatus.OK);
    }

    //질문 조회 시 질문 조회수를 처리
    @GetMapping("/{question-id}")
    public ResponseEntity getQuestion(@Positive @PathVariable("question-id") Long questionId,
                                      HttpServletRequest servletRequest,
                                      HttpServletResponse servletResponse) {
        Question findQuestion = questionService.findQuestion(questionId);
        QuestionDto.Response response = mapper.questionToResponseDto(findQuestion);

        questionService.viewCountValidation(findQuestion, servletRequest, servletResponse);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    //질문 조회 시 답변 조회를 처리
    @GetMapping("/{question-id}/answers")
    public ResponseEntity getAnswersByQuestionId(@Positive @PathVariable("question-id") Long questionId) {
        Question question = questionService.findQuestion(questionId);
        List<AnswerDto.responseAnswer> answers =
                answerMapper.answersToResponseAnswers(question.getAnswers());
        QuestionDto.AnswerResponse response =
                mapper.responseToAnswerResponseDto(answers, answers.size());
        return new ResponseEntity(
                new SingleResponse<>(response), HttpStatus.OK);
    }

    //질문 전체 조회
    @GetMapping
    public ResponseEntity getQuestions() {
        List<Question> questions = questionService.findQuestions();

        return new ResponseEntity<>(new SingleResponseDto<>(questions), HttpStatus.OK);
    }

    //질문 삭제
    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") @Positive long questionId){
        questionService.deleteQuestion(questionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}