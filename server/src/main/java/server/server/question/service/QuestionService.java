package server.server.question.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.server.answer.repository.AnswerRepository;
import server.server.question.entity.Question;
import server.server.question.exception.BusinessLogicException;
import server.server.question.exception.ExceptionCode;
import server.server.question.repository.QuestionRepository;
import server.server.user.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Arrays;
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

        // 로그인한 사용자가 맞는지 확인
        // 로그인을 안하면 로그인 하라고 해야함...

        // 로그인을 하면 생성
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
        Optional.ofNullable(question.getContentProblem())
                .ifPresent(contentProblem -> findQuestion.setContentProblem(contentProblem));
        //질문 문제 해결 수정
        Optional.ofNullable(question.getContentTried())
                .ifPresent(contentTried -> findQuestion.setContentTried(contentTried));
        findQuestion.setModifiedAt(LocalDateTime.now());
        return questionRepository.save(findQuestion);
    }

    //질문 조회(1개만) - 즉 선택
    public Question findQuestion(long questionId){

        return findVerifiedQuestion(questionId);
    }

    //질문 조회(전채)
    public Page<Question> findQuestions(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("questionId").descending());
        return questionRepository.findAll(pageable);

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
                            question.addViewCount();
                            c.setValue(c.getValue() + "[" + id + "]");
                        }
                        return c;
                    })
                    .orElseGet(() -> {
                        question.addViewCount();
                        return new Cookie("postView", "[" + id + "]");
                    });
        } else {
            question.addViewCount();
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

}
