package server.server.questionVote.service;

import org.springframework.stereotype.Service;
import server.server.question.service.QuestionService;
import server.server.questionVote.entity.QuestionVote;
import server.server.questionVote.repository.QuestionVoteRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class QuestionVoteService {
    private QuestionVoteRepository questionVoteRepository;
    private QuestionService questionService;

    public QuestionVoteService(QuestionVoteRepository questionVoteRepository, QuestionService questionService) {
        this.questionVoteRepository = questionVoteRepository;
        this.questionService = questionService;
    }

    public QuestionVote creteQuestionVote(QuestionVote questionVote){

        //질문 존재 여부
        long questionId = questionVote.getQuestion().getQuestionId();
        questionService.findVerifiedQuestion(questionId);

        //해당 질문에 투표 여부
        Optional<QuestionVote> optionQuestionVote =
                questionVoteRepository.findByQuestionId(questionId);
        if(optionQuestionVote.isPresent()){
            QuestionVote findVote = optionQuestionVote.get();
            if(findVote.getQuestionVoteStatus() == questionVote.getQuestionVoteStatus()){
                deleteQuestionVote(findVote.getQuestionVoteId());
                return null;
            } else{
                throw new RuntimeException("ALREADY_EXIST_VOTE");
            }
        }

        return questionVoteRepository.save(questionVote);

    }

    public void deleteQuestionVote(long questionVoteId){
        QuestionVote questionVote = findVerifiedQuestionVote(questionVoteId);

        questionVoteRepository.delete(questionVote);
    }

    // questionVote 존재하는지 확인
    public QuestionVote findVerifiedQuestionVote(long questionVoteId){
        Optional<QuestionVote> questionVote =
                questionVoteRepository.findById(questionVoteId);

        return questionVote.orElseThrow(()->
                new RuntimeException("NOT_EXIST_VOTE"));
    }
}
