package server.server.command.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import server.server.answer.entity.Answer;
import server.server.command.entity.Command;

public interface CommandRepository extends JpaRepository<Command, Long> {
    Page<Command> finaAllByAnswerAndCommandStatus(Pageable pageable, @Param("Answer") Answer answer, @Param("commandStatus") Command.CommandStatus commandStatus);
}
