import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import WritingGuide from './WritingGuide';
import TitleInput from './TitleInput';
import ProblemInput from './ProblemInput';
import TriedInput from './TriedInput';
import { QuestionBGImg } from '../Icons';
import ErrorPage from '../../pages/ErrorPage';

function AskQuestion() {
  const [title, setTitle] = useState('');
  const [problem, setProblem] = useState('');
  const [tried, setTried] = useState('');
  const navigate = useNavigate();
  const BASE_URL = process.env.REACT_APP_BASE_URL;

  const onClickHandler = async () => {
    const data = {
      title,
      problem,
      tried,
    };

    const url = `${BASE_URL}/questions/new`;

    try {
      const response = await axios.post(url, data);
      if (response && response.status >= 200 && response.status < 300) navigate('/');
    } catch (error) {
      return <ErrorPage />;
    }
  };

  return (
    <div className="flex w-full flex-col">
      <div className="flex justify-between items-center mb-7 ">
        <h1 className="text-4xl font-semiold">Ask a public question</h1>
        <QuestionBGImg />
      </div>
      <WritingGuide />
      <TitleInput setTitle={setTitle} title={title} />
      <ProblemInput setQuillText={setProblem} quillText={problem} />
      <TriedInput setQuillText={setTried} quillText={tried} />
      <button
        type="button"
        className="flex bg-[#1e95ff] hover:bg-[#0074CC] text-white rounded-[4px] p-2 h-[36px] w-fit gap-1 mt-2"
        onClick={onClickHandler}
      >
        Put your question
      </button>
    </div>
  );
}

export default AskQuestion;
