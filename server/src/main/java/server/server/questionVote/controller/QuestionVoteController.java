package server.server.questionVote.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.server.questionVote.dto.QuestionVoteDto;
import server.server.questionVote.entity.QuestionVote;
import server.server.questionVote.mapper.QuestionVoteMapper;
import server.server.questionVote.service.QuestionVoteService;
import server.server.utils.UriCreator;

import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@CrossOrigin
@RequestMapping("/questions")
public class QuestionVoteController {
    private final String DEFAULT_URL = "/questions";
    private final QuestionVoteService questionVoteService;
    private final QuestionVoteMapper mapper;

    public QuestionVoteController(QuestionVoteService questionVoteService, QuestionVoteMapper mapper) {
        this.questionVoteService = questionVoteService;
        this.mapper = mapper;
    }

    @PostMapping("/{question-id}")
    public ResponseEntity postQuestion(@PathVariable("question-id") long questionId,
                                       @RequestBody QuestionVoteDto.PostDto postQuestionVote){

        postQuestionVote.setQuestionId(questionId);
        QuestionVote questionVote = questionVoteService.creteQuestionVote(
                mapper.questionVotePostQuestionVote(postQuestionVote));


        URI location = UriCreator.createUri(DEFAULT_URL, questionId);


        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{question-vote-id}/vote")
    public ResponseEntity deleteQuestionVote(@PathVariable("question-vote-id") @Positive long questionVoteId){
        questionVoteService.deleteQuestionVote(questionVoteId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
