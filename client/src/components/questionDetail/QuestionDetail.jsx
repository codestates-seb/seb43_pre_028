import { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import FadeLoader from 'react-spinners/FadeLoader';

import { selectQuestion } from '../../store/questionDetailSlice';
import { fetchQuestion } from '../../api/questionDetail';
import Answers from './component/Answers';
import Question from './component/Question';
import AnswerForm from './component/AnswerForm';

export default function QuestionDetail() {
  const dispatch = useDispatch();
  const { status, question } = useSelector(selectQuestion);

  useEffect(() => {
    async function fetchQuestionData() {
      await dispatch(fetchQuestion('123'));
    }
    fetchQuestionData();
  }, [dispatch]);

  // 질문과 답변의 상세 페이지를 렌더링하는 컴포넌트
  return (
    <section className="flex w-full flex-col pl-6">
      {status === 'loading' && (
        <div className="flex w-full h-[90vh] justify-center items-center bg-red">
          <FadeLoader className="flex w-full bg-red" />
        </div>
      )}
      {status === 'succeed' && (
        <div>
          <Question data={question} />
          <Answers data={question} />
          <AnswerForm />
        </div>
      )}
    </section>
  );
}
