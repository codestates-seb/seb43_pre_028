import { useState } from 'react';
import WritingGuide from './WritingGuide';
import TitleInput from './TitleInput';
import ProblemInput from './ProblemInput';
import TriedInput from './TriedInput';
import { QuestionBGImg } from '../Icons';

function AskQuestion() {
  const [title, setTitle] = useState('');
  const [problem, setProblem] = useState('');
  const [tried, setTried] = useState('');

  // TODO : toolkit 적용 방식
  // TODO : 유저정보 어떻게 받아올지

  const onClickHandler = async () => {
    const data = {
      title,
      problem,
      tried,
      // id:UserId
    };
    await fetch('주소', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    }).then(response => response.json());
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
