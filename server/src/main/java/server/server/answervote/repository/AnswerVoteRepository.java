package server.server.answervote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.server.answervote.entity.AnswerVote;

public interface AnswerVoteRepository extends JpaRepository<AnswerVote, Long> {
}
