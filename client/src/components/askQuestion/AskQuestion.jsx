import WritingGuide from './WritingGuide';
import TitleInput from './TitleInput';
import ProblemInput from './ProblemInput';
import TriedInput from './TriedInput';
import { QuestionBGImg } from '../Icons';

function AskQuestion() {
  return (
    <div className="flex w-full flex-col">
      <div className="flex justify-between items-center mb-7 ">
        <h1 className="text-4xl font-semiold">Ask a public question</h1>
        <QuestionBGImg />
      </div>
      <WritingGuide />
      <TitleInput />
      <ProblemInput />
      <TriedInput />
      <button
        type="button"
        className="flex bg-[#1e95ff] hover:bg-[#0074CC] text-white rounded-[4px] p-2 h-[36px] w-fit gap-1 mt-2"
      >
        Put your question
      </button>
    </div>
  );
}

export default AskQuestion;
