import { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';

import ContentItem from './ContentItem';
import { fetchAllQuestions } from '../../api/question';
import Pagination from '../ui/Pagination';
import Loading from '../ui/Loading';

function Content() {
  const { status, questions } = useSelector(state => state.question);
  const [selectedIndex, setSelectedIndex] = useState(0);
  const dispatch = useDispatch();
  const questionNumsPerPage = 10;

  useEffect(() => {
    dispatch(fetchAllQuestions());
  }, [dispatch]);

  const onPaginationButtonClickHandler = (e, selectedPageIndex) => {
    setSelectedIndex(selectedPageIndex);
  };

  return (
    <div className="questions-container">
      {status === 'loading' && <Loading />}

      {status === 'succeed' &&
        questions
          .slice(
            selectedIndex * questionNumsPerPage,
            (selectedIndex + 1) * questionNumsPerPage,
          )
          .map(question => <ContentItem key={question.questionId} {...question} />)}
      {status === 'succeed' && (
        <Pagination
          selectedIndex={selectedIndex}
          questionNumsPerPage={questionNumsPerPage}
          onPaginationButtonClickHandler={onPaginationButtonClickHandler}
          buttons={Array(Math.ceil(questions.length / questionNumsPerPage))
            .fill(0)
            .map((_, index) => index)}
        />
      )}
    </div>
  );
}

export default Content;
