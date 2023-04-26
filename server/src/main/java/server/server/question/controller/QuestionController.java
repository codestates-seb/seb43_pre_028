package server.server.question.controller;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
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
import java.util.ArrayList;
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
    @PostMapping("/new")
    public ResponseEntity postQuestion(@Valid @RequestBody QuestionDto.Post postQuestion){
        Question question = mapper.postDtoToQuestion(postQuestion);
        Question createdQuestion = questionService.creteQuestion(question);

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.questionToResponseDto(createdQuestion)), HttpStatus.CREATED);

//        JSONObject questionJson1 = new JSONObject();
//        JSONObject questionContentJson1 = new JSONObject();
//        questionJson1.put("questionId", 1);
//        questionJson1.put("title", "post Test");
//        questionJson1.put("content", questionContentJson1);
//        questionContentJson1.put("problem", "질문 생성이 되나?");
//        questionContentJson1.put("tried", "진짜 되겠지?");
//        questionJson1.put("views", 0);
//        questionJson1.put("votes", 0);
//        questionJson1.put("answers", 0);
//        questionJson1.put("userName", "지현님 안뇽");
//        questionJson1.put("userImage", "https://lh3.googleusercontent.com/a/AGNmyxZ3yZ7RupMJPJCP_NwE0ngixsfdYY3OmIqScQmx=k-s32");
//        questionJson1.put("askedCount", 10);
//        questionJson1.put("createdAt", "have to compute");
//        questionJson1.put("modifiedAt", "2023-04-21T00:43:02.9797101");
//
//        ArrayList<JSONObject> questionJson = new ArrayList<>();
//
//        questionJson.add(questionJson1);
//
//        return new ResponseEntity<>((questionJson), HttpStatus.OK);

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
                answerMapper.answersToResponseAnswers(question.getAnswer());
        QuestionDto.AnswerResponse response =
                mapper.responseToAnswerResponseDto(answers, answers.size());
        return new ResponseEntity(
                new SingleResponse<>(response), HttpStatus.OK);
    }

    //질문 전체 조회
    @GetMapping
    public ResponseEntity getQuestions() {

        //List<Question> questions = questionService.findQuestions();

        JSONObject questionJson1 = new JSONObject();
        JSONObject questionContentJson1 = new JSONObject();
        questionJson1.put("questionId", 1);
        questionJson1.put("title", "How to access downloaded OSM data");
        questionJson1.put("content", questionContentJson1);
        questionContentJson1.put("problem", "When I send post request JSON to server username and score page being refreshed. Patch request does not have this problem page not being refreshed.");
        questionContentJson1.put("tried", "Im working with js/node. Following the instructions at You requested too many nodes (limit is 50000). Either request a smaller area, or use planet.osm I have downloaded a 670MB file representing nodes in a geographic area. When I open it in vim it looks like xml to me");
        questionJson1.put("views", 7);
        questionJson1.put("votes", 6);
        questionJson1.put("answers", 5);
        questionJson1.put("userName", "승주님은 톰");
        questionJson1.put("userImage", "https://lh3.googleusercontent.com/a/AGNmyxZ3yZ7RupMJPJCP_NwE0ngixsfdYY3OmIqScQmx=k-s32");
        questionJson1.put("askedCount", 10);
        questionJson1.put("createdAt", "have to compute");
        questionJson1.put("modifiedAt", "2023-03-21T00:43:02.9797101");

        JSONObject questionJson2 = new JSONObject();
        JSONObject questionContentJson2 = new JSONObject();
        questionJson2.put("questionId", 2);
        questionJson2.put("title", "Why is the page refreshed after javascript post request?");
        questionJson2.put("content", questionContentJson2);
        questionContentJson2.put("problem", "진짜 큰일 났다.");
        questionContentJson2.put("tried", "성공은 해야 하는데...");
        questionJson2.put("views", 5);
        questionJson2.put("votes", 6);
        questionJson2.put("answers", 8);
        questionJson2.put("userName", "기정님있어요!!");
        questionJson2.put("userImage", "https://www.gravatar.com/avatar/1b375c795476432e64d4433a651d2804?s=32&d=identicon&r=PG");
        questionJson2.put("askedCount", 382);
        questionJson2.put("createdAt", "2023-04-26 05:18:11");
        questionJson2.put("modifiedAt", "2023-04-26 05:18:11");

        JSONObject questionJson3 = new JSONObject();
        JSONObject questionContentJson3 = new JSONObject();
        questionJson3.put("questionId", 3);
        questionJson3.put("title", "AWS Amplify Pub/Sub entering disconnect state without any other logs");
        questionJson3.put("content", questionContentJson3);
        questionContentJson3.put("problem", "I have been working in both Python and Rust for quite a while now, and have started to get irritated about python’s lack of a proper default __repr__.");
        questionContentJson3.put("tried", "This isn't perfect (I deliberately printed an empty string and inheritance is funky too), but it does the job for me. I understand that, by adding a bunch more if-statements, I can probably get this pretty (and, if there is interest, I'd have the free time to do that and turn it into a small python package), but that is not the point. I feel like this should exist already, and I simply cannot find it.");
        questionJson3.put("views", 4);
        questionJson3.put("votes", 1);
        questionJson3.put("answers", 2);
        questionJson3.put("userName", "뭐 어쩌라고");
        questionJson3.put("userImage", "https://notion-emojis.s3-us-west-2.amazonaws.com/prod/svg-twitter/1f61c.svg");
        questionJson3.put("askedCount", 5);
        questionJson3.put("createdAt", "have to compute");
        questionJson3.put("modifiedAt", "2023-03-26T00:43:02.9797101");

        JSONObject questionJson4 = new JSONObject();
        JSONObject questionContentJson4 = new JSONObject();
        questionJson4.put("questionId", 4);
        questionJson4.put("title", "AWS Amplify Pub/Sub entering disconnect state without any other logs");
        questionJson4.put("content", questionContentJson4);
        questionContentJson4.put("problem", "I have been working in both Python and Rust for quite a while now, and have started to get irritated about python’s lack of a proper default __repr__.");
        questionContentJson4.put("tried", "This isn't perfect (I deliberately printed an empty string and inheritance is funky too), but it does the job for me. I understand that, by adding a bunch more if-statements, I can probably get this pretty (and, if there is interest, I'd have the free time to do that and turn it into a small python package), but that is not the point. I feel like this should exist already, and I simply cannot find it.");
        questionJson4.put("views", 4);
        questionJson4.put("votes", 1);
        questionJson4.put("answers", 2);
        questionJson4.put("userName", "승주님");
        questionJson4.put("userImage", "https://notion-emojis.s3-us-west-2.amazonaws.com/prod/svg-twitter/1f61c.svg");
        questionJson4.put("askedCount", 5);
        questionJson4.put("createdAt", "have to compute");
        questionJson4.put("modifiedAt", "2023-03-26T00:43:02.9797101");

        JSONObject questionJson5 = new JSONObject();
        JSONObject questionContentJson5 = new JSONObject();
        questionJson5.put("questionId", 5);
        questionJson5.put("title", "AWS Amplify Pub/Sub entering disconnect state without any other logs");
        questionJson5.put("content", questionContentJson5);
        questionContentJson5.put("problem", "I have been working in both Python and Rust for quite a while now, and have started to get irritated about python’s lack of a proper default __repr__.");
        questionContentJson5.put("tried", "This isn't perfect (I deliberately printed an empty string and inheritance is funky too), but it does the job for me. I understand that, by adding a bunch more if-statements, I can probably get this pretty (and, if there is interest, I'd have the free time to do that and turn it into a small python package), but that is not the point. I feel like this should exist already, and I simply cannot find it.");
        questionJson5.put("views", 4);
        questionJson5.put("votes", 1);
        questionJson5.put("answers", 2);
        questionJson5.put("userName", "지현님");
        questionJson5.put("userImage", "https://notion-emojis.s3-us-west-2.amazonaws.com/prod/svg-twitter/1f61c.svg");
        questionJson5.put("askedCount", 5);
        questionJson5.put("createdAt", "have to compute");
        questionJson5.put("modifiedAt", "2023-03-26T00:43:02.9797101");

        JSONObject questionJson6 = new JSONObject();
        JSONObject questionContentJson6 = new JSONObject();
        questionJson6.put("questionId", 6);
        questionJson6.put("title", "AWS Amplify Pub/Sub entering disconnect state without any other logs");
        questionJson6.put("content", questionContentJson6);
        questionContentJson6.put("problem", "I have been working in both Python and Rust for quite a while now, and have started to get irritated about python’s lack of a proper default __repr__.");
        questionContentJson6.put("tried", "This isn't perfect (I deliberately printed an empty string and inheritance is funky too), but it does the job for me. I understand that, by adding a bunch more if-statements, I can probably get this pretty (and, if there is interest, I'd have the free time to do that and turn it into a small python package), but that is not the point. I feel like this should exist already, and I simply cannot find it.");
        questionJson6.put("views", 4);
        questionJson6.put("votes", 1);
        questionJson6.put("answers", 2);
        questionJson6.put("userName", "기정님");
        questionJson6.put("userImage", "https://picsum.photos/200/300/?blur");
        questionJson6.put("askedCount", 5);
        questionJson6.put("createdAt", "have to compute");
        questionJson6.put("modifiedAt", "2023-03-26T00:43:02.9797101");

        JSONObject questionJson7 = new JSONObject();
        JSONObject questionContentJson7 = new JSONObject();
        questionJson7.put("questionId", 7);
        questionJson7.put("title", "AWS Amplify Pub/Sub entering disconnect state without any other logs");
        questionJson7.put("content", questionContentJson3);
        questionContentJson7.put("problem", "I have been working in both Python and Rust for quite a while now, and have started to get irritated about python’s lack of a proper default __repr__.");
        questionContentJson7.put("tried", "This isn't perfect (I deliberately printed an empty string and inheritance is funky too), but it does the job for me. I understand that, by adding a bunch more if-statements, I can probably get this pretty (and, if there is interest, I'd have the free time to do that and turn it into a small python package), but that is not the point. I feel like this should exist already, and I simply cannot find it.");
        questionJson7.put("views", 4);
        questionJson7.put("votes", 1);
        questionJson7.put("answers", 2);
        questionJson7.put("userName", "혜미님");
        questionJson7.put("userImage", "https://i.pravatar.cc");
        questionJson7.put("askedCount", 5);
        questionJson7.put("createdAt", "have to compute");
        questionJson7.put("modifiedAt", "2023-03-26T00:43:02.9797101");

        JSONObject questionJson8 = new JSONObject();
        JSONObject questionContentJson8 = new JSONObject();
        questionJson8.put("questionId", 8);
        questionJson8.put("title", "AWS Amplify Pub/Sub entering disconnect state without any other logs");
        questionJson8.put("content", questionContentJson7);
        questionContentJson8.put("problem", "I have been working in both Python and Rust for quite a while now, and have started to get irritated about python’s lack of a proper default __repr__.");
        questionContentJson8.put("tried", "This isn't perfect (I deliberately printed an empty string and inheritance is funky too), but it does the job for me. I understand that, by adding a bunch more if-statements, I can probably get this pretty (and, if there is interest, I'd have the free time to do that and turn it into a small python package), but that is not the point. I feel like this should exist already, and I simply cannot find it.");
        questionJson8.put("views", 4);
        questionJson8.put("votes", 1);
        questionJson8.put("answers", 2);
        questionJson8.put("userName", "경아님");
        questionJson8.put("userImage", "https://i.pravatar.cc");
        questionJson8.put("askedCount", 5);
        questionJson8.put("createdAt", "have to compute");
        questionJson8.put("modifiedAt", "2023-03-26T00:43:02.9797101");

        JSONObject questionJson9 = new JSONObject();
        JSONObject questionContentJson9 = new JSONObject();
        questionJson9.put("questionId", 9);
        questionJson9.put("title", "AWS Amplify Pub/Sub entering disconnect state without any other logs");
        questionJson9.put("content", questionContentJson9);
        questionContentJson9.put("problem", "I have been working in both Python and Rust for quite a while now, and have started to get irritated about python’s lack of a proper default __repr__.");
        questionContentJson9.put("tried", "This isn't perfect (I deliberately printed an empty string and inheritance is funky too), but it does the job for me. I understand that, by adding a bunch more if-statements, I can probably get this pretty (and, if there is interest, I'd have the free time to do that and turn it into a small python package), but that is not the point. I feel like this should exist already, and I simply cannot find it.");
        questionJson9.put("views", 4);
        questionJson9.put("votes", 1);
        questionJson9.put("answers", 2);
        questionJson9.put("userName", "수진님 run");
        questionJson9.put("userImage", "https://i.pravatar.cc");
        questionJson9.put("askedCount", 5);
        questionJson9.put("createdAt", "have to compute");
        questionJson9.put("modifiedAt", "2023-03-26T00:43:02.9797101");

        JSONObject questionJson10 = new JSONObject();
        JSONObject questionContentJson10 = new JSONObject();
        questionJson10.put("questionId", 10);
        questionJson10.put("title", "AWS Amplify Pub/Sub entering disconnect state without any other logs");
        questionJson10.put("content", questionContentJson10);
        questionContentJson10.put("problem", "I have been working in both Python and Rust for quite a while now, and have started to get irritated about python’s lack of a proper default __repr__.");
        questionContentJson10.put("tried", "This isn't perfect (I deliberately printed an empty string and inheritance is funky too), but it does the job for me. I understand that, by adding a bunch more if-statements, I can probably get this pretty (and, if there is interest, I'd have the free time to do that and turn it into a small python package), but that is not the point. I feel like this should exist already, and I simply cannot find it.");
        questionJson10.put("views", 4);
        questionJson10.put("votes", 1);
        questionJson10.put("answers", 2);
        questionJson10.put("userName", "힘들다");
        questionJson10.put("userImage", "https://i.pravatar.cc");
        questionJson10.put("askedCount", 5);
        questionJson10.put("createdAt", "have to compute");
        questionJson10.put("modifiedAt", "2023-03-26T00:43:02.9797101");

        JSONObject questionJson11 = new JSONObject();
        JSONObject questionContentJson11 = new JSONObject();
        questionJson11.put("questionId", 11);
        questionJson11.put("title", "AWS Amplify Pub/Sub entering disconnect state without any other logs");
        questionJson11.put("content", questionContentJson11);
        questionContentJson11.put("problem", "I have been working in both Python and Rust for quite a while now, and have started to get irritated about python’s lack of a proper default __repr__.");
        questionContentJson11.put("tried", "This isn't perfect (I deliberately printed an empty string and inheritance is funky too), but it does the job for me. I understand that, by adding a bunch more if-statements, I can probably get this pretty (and, if there is interest, I'd have the free time to do that and turn it into a small python package), but that is not the point. I feel like this should exist already, and I simply cannot find it.");
        questionJson11.put("views", 4);
        questionJson11.put("votes", 1);
        questionJson11.put("answers", 2);
        questionJson11.put("userName", "내가 너무 부족하다");
        questionJson11.put("userImage", "https://i.pravatar.cc");
        questionJson11.put("askedCount", 5);
        questionJson11.put("createdAt", "have to compute");
        questionJson11.put("modifiedAt", "2023-03-26T00:43:02.9797101");

        JSONObject questionJson12 = new JSONObject();
        JSONObject questionContentJson12 = new JSONObject();
        questionJson12.put("questionId", 12);
        questionJson12.put("title", "AWS Amplify Pub/Sub entering disconnect state without any other logs");
        questionJson12.put("content", questionContentJson3);
        questionContentJson12.put("problem", "I have been working in both Python and Rust for quite a while now, and have started to get irritated about python’s lack of a proper default __repr__.");
        questionContentJson12.put("tried", "This isn't perfect (I deliberately printed an empty string and inheritance is funky too), but it does the job for me. I understand that, by adding a bunch more if-statements, I can probably get this pretty (and, if there is interest, I'd have the free time to do that and turn it into a small python package), but that is not the point. I feel like this should exist already, and I simply cannot find it.");
        questionJson12.put("views", 4);
        questionJson12.put("votes", 1);
        questionJson12.put("answers", 2);
        questionJson12.put("userName", "진짜...");
        questionJson12.put("userImage", "https://i.pravatar.cc");
        questionJson12.put("askedCount", 5);
        questionJson12.put("createdAt", "have to compute");
        questionJson12.put("modifiedAt", "2023-03-26T00:43:02.9797101");

        JSONObject questionJson13 = new JSONObject();
        JSONObject questionContentJson13 = new JSONObject();
        questionJson13.put("questionId", 13);
        questionJson13.put("title", "AWS Amplify Pub/Sub entering disconnect state without any other logs");
        questionJson13.put("content", questionContentJson13);
        questionContentJson13.put("problem", "I have been working in both Python and Rust for quite a while now, and have started to get irritated about python’s lack of a proper default __repr__.");
        questionContentJson13.put("tried", "This isn't perfect (I deliberately printed an empty string and inheritance is funky too), but it does the job for me. I understand that, by adding a bunch more if-statements, I can probably get this pretty (and, if there is interest, I'd have the free time to do that and turn it into a small python package), but that is not the point. I feel like this should exist already, and I simply cannot find it.");
        questionJson13.put("views", 4);
        questionJson13.put("votes", 1);
        questionJson13.put("answers", 2);
        questionJson13.put("userName", "돌아버리 겠다");
        questionJson13.put("userImage", "https://i.pravatar.cc");
        questionJson13.put("askedCount", 5);
        questionJson13.put("createdAt", "have to compute");
        questionJson13.put("modifiedAt", "2023-03-26T00:43:02.9797101");

        JSONObject questionJson14 = new JSONObject();
        JSONObject questionContentJson14 = new JSONObject();
        questionJson14.put("questionId", 14);
        questionJson14.put("title", "AWS Amplify Pub/Sub entering disconnect state without any other logs");
        questionJson14.put("content", questionContentJson14);
        questionContentJson14.put("problem", "I have been working in both Python and Rust for quite a while now, and have started to get irritated about python’s lack of a proper default __repr__.");
        questionContentJson14.put("tried", "This isn't perfect (I deliberately printed an empty string and inheritance is funky too), but it does the job for me. I understand that, by adding a bunch more if-statements, I can probably get this pretty (and, if there is interest, I'd have the free time to do that and turn it into a small python package), but that is not the point. I feel like this should exist already, and I simply cannot find it.");
        questionJson14.put("views", 4);
        questionJson14.put("votes", 1);
        questionJson14.put("answers", 2);
        questionJson14.put("userName", "하기 싫어요");
        questionJson14.put("userImage", "https://i.pravatar.cc");
        questionJson14.put("askedCount", 5);
        questionJson14.put("createdAt", "have to compute");
        questionJson14.put("modifiedAt", "2023-03-26T00:43:02.9797101");

        JSONObject questionJson15 = new JSONObject();
        JSONObject questionContentJson15 = new JSONObject();
        questionJson15.put("questionId", 15);
        questionJson15.put("title", "AWS Amplify Pub/Sub entering disconnect state without any other logs");
        questionJson15.put("content", questionContentJson15);
        questionContentJson3.put("problem", "I have been working in both Python and Rust for quite a while now, and have started to get irritated about python’s lack of a proper default __repr__.");
        questionContentJson3.put("tried", "This isn't perfect (I deliberately printed an empty string and inheritance is funky too), but it does the job for me. I understand that, by adding a bunch more if-statements, I can probably get this pretty (and, if there is interest, I'd have the free time to do that and turn it into a small python package), but that is not the point. I feel like this should exist already, and I simply cannot find it.");
        questionJson15.put("views", 4);
        questionJson15.put("votes", 1);
        questionJson15.put("answers", 2);
        questionJson15.put("userName", "도망가고 싶어요");
        questionJson15.put("userImage", "https://i.pravatar.cc");
        questionJson15.put("askedCount", 5);
        questionJson15.put("createdAt", "have to compute");
        questionJson15.put("modifiedAt", "2023-03-26T00:43:02.9797101");

        JSONObject questionJson16 = new JSONObject();
        JSONObject questionContentJson16 = new JSONObject();
        questionJson16.put("questionId", 16);
        questionJson16.put("title", "AWS Amplify Pub/Sub entering disconnect state without any other logs");
        questionJson16.put("content", questionContentJson16);
        questionContentJson16.put("problem", "I have been working in both Python and Rust for quite a while now, and have started to get irritated about python’s lack of a proper default __repr__.");
        questionContentJson16.put("tried", "This isn't perfect (I deliberately printed an empty string and inheritance is funky too), but it does the job for me. I understand that, by adding a bunch more if-statements, I can probably get this pretty (and, if there is interest, I'd have the free time to do that and turn it into a small python package), but that is not the point. I feel like this should exist already, and I simply cannot find it.");
        questionJson16.put("views", 4);
        questionJson16.put("votes", 1);
        questionJson16.put("answers", 2);
        questionJson16.put("userName", "살려주세요");
        questionJson16.put("userImage", "https://i.pravatar.cc");
        questionJson16.put("askedCount", 5);
        questionJson16.put("createdAt", "have to compute");
        questionJson16.put("modifiedAt", "2023-03-26T00:43:02.9797101");

        JSONObject questionJson17 = new JSONObject();
        JSONObject questionContentJson17 = new JSONObject();
        questionJson17.put("questionId", 17);
        questionJson17.put("title", "AWS Amplify Pub/Sub entering disconnect state without any other logs");
        questionJson17.put("content", questionContentJson3);
        questionContentJson17.put("problem", "I have been working in both Python and Rust for quite a while now, and have started to get irritated about python’s lack of a proper default __repr__.");
        questionContentJson17.put("tried", "This isn't perfect (I deliberately printed an empty string and inheritance is funky too), but it does the job for me. I understand that, by adding a bunch more if-statements, I can probably get this pretty (and, if there is interest, I'd have the free time to do that and turn it into a small python package), but that is not the point. I feel like this should exist already, and I simply cannot find it.");
        questionJson17.put("views", 4);
        questionJson17.put("votes", 1);
        questionJson17.put("answers", 2);
        questionJson17.put("userName", "배고파");
        questionJson17.put("userImage", "https://i.pravatar.cc");
        questionJson17.put("askedCount", 5);
        questionJson17.put("createdAt", "have to compute");
        questionJson17.put("modifiedAt", "2023-03-26T00:43:02.9797101");

        ArrayList<JSONObject> questionJson = new ArrayList<>();

        questionJson.add(questionJson1);
        questionJson.add(questionJson2);
        questionJson.add(questionJson3);
        questionJson.add(questionJson4);
        questionJson.add(questionJson5);
        questionJson.add(questionJson6);
        questionJson.add(questionJson7);
        questionJson.add(questionJson8);
        questionJson.add(questionJson9);
        questionJson.add(questionJson10);
        questionJson.add(questionJson11);
        questionJson.add(questionJson12);
        questionJson.add(questionJson13);
        questionJson.add(questionJson14);
        questionJson.add(questionJson15);
        questionJson.add(questionJson16);
        questionJson.add(questionJson17);

        return new ResponseEntity<>((questionJson), HttpStatus.OK);

        //return new ResponseEntity<>(new SingleResponseDto<>(questions), HttpStatus.OK);
    }

    //질문 삭제
    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") @Positive long questionId){
        questionService.deleteQuestion(questionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}