package server.server.answer.service;

import org.springframework.stereotype.Service;
import preproject.answer.entity.Answer;
import preproject.answer.exception.BusinessLogicException;
import preproject.answer.exception.ExceptionCode;
import preproject.answer.repository.AnswerRepository;

import java.util.List;
import java.util.Optional;

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
                .ifPresent(findAnswer::setContent);
        return answerRepository.save(findAnswer);
    }

    public Answer findAnswer(long answerId) {  // 특정 회원 조회

        return findVerifiedAnswer(answerId);
    }

    public List<Answer> findAnswers() {  // 모든 회원 조회

        return (List<Answer>) answerRepository.findAll();
    }

    public void deleteAnswer(long answerId) {  // 특정 회원 삭제
        Answer findAnswer = findVerifiedAnswer(answerId);

        answerRepository.delete(findAnswer);
    }

    public Answer findVerifiedAnswer(long answerId) {  // 해당 답변글의 존재 유무 체크
        Optional<Answer> optionalAnswer =
                answerRepository.findByAnswer(String.valueOf(answerId));
        Answer findAnswer =
                optionalAnswer.orElseThrow(() -> new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));

        return findAnswer;
    }
}
