package server.server.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.server.question.entity.Question;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findByTitle(String title);

}
