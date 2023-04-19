package com.codestates.server.question.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import server.server.question.entity.Question;
import server.server.question.exception.BusinessLogicException;
import server.server.question.exception.ExceptionCode;
import server.server.question.repository.QuestionRepository;

import java.util.Optional;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    //질문 생성
    public Question creteQuestion(Question question){

        return questionRepository.save(question);
    }

    //질문 수정
    public Question updateQuestion(Question question){
        //질문 존재 여부 확인
        Question findQuestion = findVerifiedQuestion(question.getQuestionId());

        //제목 수정
        Optional.ofNullable(question.getTitle())
                .ifPresent(title -> findQuestion.setTitle(title));
        //질문 문제 수정
        Optional.ofNullable(question.getContentProblem())
                .ifPresent(content -> findQuestion.setContentProblem(content));
        //질문 문제 해결 수정
        Optional.ofNullable(question.getContentTried())
                .ifPresent(content -> findQuestion.setContentTried(content));
        //수정 시간 등록
        Optional.ofNullable(question.getModifiedAt())
                .ifPresent(modifiedAt -> findQuestion.setModifiedAt(modifiedAt));

        return questionRepository.save(findQuestion);
    }

    //질문 조회(1개만) - 즉 선택
    public Question findQuestion(long questionId){
        return findVerifiedQuestion(questionId);
    }

    //질문 조회(전채)
    public Page<Question> findQuestions(int page, int size){
        return questionRepository.findAll(PageRequest.of(page, size,
                Sort.by("questionid").descending()));

    }

    //질문 삭제
    public void deleteQuestion(long questionId){
        Question findquestion = findVerifiedQuestion(questionId);

        questionRepository.delete(findquestion);
    }


    //해당 게시글이 존재하는지 체크
    public Question findVerifiedQuestion(long questionId){
        Optional<Question> optionalQuestion =
                questionRepository.findById(questionId);
        Question findQuestion =
                optionalQuestion.orElseThrow(() -> new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));

        return findQuestion;
    }


}
