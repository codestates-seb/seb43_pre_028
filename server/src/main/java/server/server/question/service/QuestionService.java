package server.server.question.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.server.answer.repository.AnswerRepository;
import server.server.exception.BusinessLogicException;
import server.server.exception.ExceptionCode;
import server.server.question.entity.Question;
import server.server.question.repository.QuestionRepository;
import server.server.user.entity.User;
import server.server.user.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuestionService {
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;
    private UserService userService;

    public QuestionService(QuestionRepository questionRepository, AnswerRepository answerRepository, UserService userService) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.userService = userService;
    }

    //질문 생성
    public Question creteQuestion(Question question){

        // 회원가입한 유저의 아이디를 가져와서 그 유저가 게시판을 생성해야 되는데 어떻게?


        return questionRepository.save(question);

    }


    //질문 수정
    public Question updateQuestion(Question question){
        //질문 존재 여부 확인
        Question findQuestion = findVerifiedQuestion(question.getQuestionId());

        //제목 수정
        Optional.ofNullable(question.getTitle())
                .ifPresent(title -> findQuestion.setTitle(title));
        //질문 문제 수정
        Optional.ofNullable(question.getProblem())
                .ifPresent(problem -> findQuestion.setProblem(problem));
        //질문 문제 수정
        Optional.ofNullable(question.getTried())
                .ifPresent(tried -> findQuestion.setTried(tried));

        findQuestion.setModifiedAt(LocalDateTime.now());
        return questionRepository.save(findQuestion);
    }

    //질문 조회(1개만) - 즉 선택
    public Question findQuestion(long questionId){

        Question question = findVerifiedQuestion(questionId);
        question.setViews(question.getViews() +1);

        return question;
    }

    //질문 조회(전체)
//    public Page<Question> findQuestions(int page, int size){
//        Pageable pageable = PageRequest.of(page, size, Sort.by("questionId").descending());
//        return questionRepository.findAll(pageable);
//
//    }

    public List<Question> findQuestions() {  // 모든 회원 조회
        return questionRepository.findAll();
    }

    //질문 삭제
    public void deleteQuestion(long questionId){
        Question findquestion = findVerifiedQuestion(questionId);

        questionRepository.delete(findquestion);
    }

    public void viewCountValidation(Question question,
                                    HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        long id = question.getQuestionId();

        Cookie cookie = null;
        if (servletRequest.getCookies() != null) {
            cookie = Arrays.stream(servletRequest.getCookies())
                    .filter(c -> c.getName().equals("postView"))    // postView 쿠키가 있는지 필터링
                    .findFirst()    // filter 조건에 일치하는 가장 앞에 있는 요소 1를 Optional 로 리턴. 없으면 empty 리턴
                    .map(c -> {     // Optional 에 Cookie 가 있으면 꺼내서 수정
                        if (!c.getValue().contains("[" + id + "]")) {
                            question.addViews();
                            c.setValue(c.getValue() + "[" + id + "]");
                        }
                        return c;
                    })
                    .orElseGet(() -> {
                        question.addViews();
                        return new Cookie("postView", "[" + id + "]");
                    });
        } else {
            question.addViews();
            cookie = new Cookie("postView", "[" + id + "]");
        }
        long todayEndSecond = LocalDate.now().atTime(LocalTime.MAX).toEpochSecond(ZoneOffset.UTC);
        long currentSecond = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        cookie.setPath("/");
        cookie.setMaxAge((int) (todayEndSecond - currentSecond));
        servletResponse.addCookie(cookie);
    }


    //해당 게시글이 존재하는지 체크
    public Question findVerifiedQuestion(long questionId){
        Optional<Question> question =
                questionRepository.findByQuestionId(questionId);
        Question findQuestion =
                question.orElseThrow(() -> new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));

        return findQuestion;
    }

    private User verifyExistingUser(User user) {

        return userService.findVerifiedUser(user.getUserId());
    }

}
