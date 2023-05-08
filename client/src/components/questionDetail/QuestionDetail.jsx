import { useEffect, useState } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import FadeLoader from 'react-spinners/FadeLoader';
import { useParams, useLocation } from 'react-router-dom';
import { selectQuestion } from '../../store/questionDetailSlice';
import { fetchQuestion } from '../../api/questionDetail';
import Answers from './component/Answers';
import Question from './component/Question';
import AnswerForm from './component/AnswerForm';

export default function QuestionDetail() {
  const dispatch = useDispatch();
  const { status, question } = useSelector(selectQuestion);
  const { questionId } = useParams();
  // const questionId = '';
  const { state } = useLocation();

  console.log(state);
  console.log(question);
  useEffect(() => {
    async function fetchQuestionData() {
      await dispatch(fetchQuestion(questionId.toString()));
    }
    fetchQuestionData();
  }, [dispatch, questionId]);

  // 질문과 답변의 상세 페이지를 렌더링하는 컴포넌트
  return (
    <section className="flex w-full flex-col pl-6">
      {console.log('hihi')}
      {status === 'loading' && (
        <div className="flex w-full h-[90vh] justify-center items-center bg-red">
          <FadeLoader className="flex w-full bg-red" />
          {console.log('hello')}
        </div>
      )}
      {status === 'succeed' && (
        <div>
          {console.log(questionId)}
          <Question data={state} />
          <Answers
            data={question.filter(answer => answer.questionId === Number(questionId))}
          />
          {/* {console.log(typeof questionId)}
          {console.log(question.filter(answer => answer.questionId === 1))} */}
          <AnswerForm />
        </div>
      )}
    </section>
  );
}
