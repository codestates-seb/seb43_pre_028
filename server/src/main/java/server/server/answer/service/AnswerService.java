package server.server.answer.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import server.server.answer.entity.Answer;
import server.server.answer.repository.AnswerRepository;

import org.springframework.transaction.annotation.Transactional;
import server.server.exception.BusinessLogicException;
import server.server.exception.ExceptionCode;
import server.server.question.service.QuestionService;
import server.server.user.service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
@Component
@Service
public class AnswerService {
    private AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer createAnswer(Answer answer) {  // 생성
        return answerRepository.save(answer);
    }

    public Answer updateAnswer(Answer answer) {  // 수정
        Answer findAnswer = findVerifiedAnswer(answer.getAnswerId());

        Optional.ofNullable(answer.getContent())
                .ifPresent(content -> findAnswer.setContent(content));

        findAnswer.setModifiedAt(LocalDateTime.now());

        return answerRepository.save(findAnswer);
    }

    public List<Answer> findAnswers() {  // 모든 회원 조회

        return answerRepository.findAll();
    }

    public void deleteAnswer(long answerId) {  // 특정 회원 삭제
        answerRepository.deleteById(answerId);
    }

    public Answer findVerifiedAnswer(long answerId) {  // 해당 답변글의 존재 유무 체크
        Answer answer = answerRepository.findByAnswerId(answerId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));

        return answer;
    }
}
