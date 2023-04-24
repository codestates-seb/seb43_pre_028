import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import FadeLoader from 'react-spinners/FadeLoader';

import ContentItem from './ContentItem';
import { fetchAllQuestions } from '../../api/question';

function Content() {
  const { status, questions } = useSelector(state => state.question);
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(fetchAllQuestions());
  }, [dispatch]);

  return (
    <div className="questions-container">
      {status === 'loading' && (
        <div className="flex w-full h-[90vh] justify-center items-center bg-red">
          <FadeLoader className="flex w-full bg-red" />
        </div>
      )}
      {status === 'succeed' &&
        questions.map(question => (
          <ContentItem key={question.questionId} {...question} />
        ))}
    </div>
  );
}

export default Content;
