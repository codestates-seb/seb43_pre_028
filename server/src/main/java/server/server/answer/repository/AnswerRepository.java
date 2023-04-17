package server.server.answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import preproject.answer.entity.Answer;

import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Optional<Answer> findByAnswer(String content);
}
