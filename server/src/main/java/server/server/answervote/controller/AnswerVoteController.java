package server.server.answervote.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.server.answervote.dto.AnswerVoteDto;
import server.server.answervote.entity.AnswerVote;
import server.server.answervote.mapper.AnswerVoteMapper;
import server.server.answervote.service.AnswerVoteService;
import server.server.utils.UriCreator;

import java.net.URI;

@CrossOrigin
@RestController
@RequestMapping("/answers")
public class AnswerVoteController {
    private final static String ANSWER_VOTE_DEFAULT_URL = "/answers";
    private final AnswerVoteService answerVoteService;
    private final AnswerVoteMapper mapper;

    public AnswerVoteController(AnswerVoteService answerVoteService, AnswerVoteMapper mapper) {
        this.answerVoteService = answerVoteService;
        this.mapper = mapper;
    }

    @PostMapping("/{answer-id}/answer-vote")  //
    public ResponseEntity postAnswerVote(@PathVariable("answer-id") Long answerId,
                                         @RequestBody AnswerVoteDto.VotePost post){
        post.setAnswerId(answerId);
        AnswerVote answerVote = answerVoteService.createAnswerVote(mapper.postDtoToAnswerVote(post));
        long answerVoteId = answerVote.getAnswerVoteId();
        URI location = UriCreator.createUri(ANSWER_VOTE_DEFAULT_URL, answerId, answerVoteId);

        AnswerVoteDto.VoteResponse response = mapper.answerVoteToResponseDto(answerVote);

        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping("/{answer-vote-id}/answer-vote")
    public ResponseEntity deleteAnswerVote(@PathVariable("answer-vote-id") Long answerVoteId){
        answerVoteService.deleteAnswerVote(answerVoteId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}