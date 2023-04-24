package server.server.questionVote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import server.server.questionVote.entity.QuestionVote;

import java.util.Optional;

public interface QuestionVoteRepository extends JpaRepository<QuestionVote, Long> {

    @Query("select q from QuestionVote q where q.question.questionId = :questionId")
    Optional<QuestionVote> findByQuestionId(@Param("questionId") long questionId);
}
