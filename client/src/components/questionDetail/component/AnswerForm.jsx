import Texteditor from '../asset/TextEditor';

function AnswerForm() {
  return (
    <div>
      <div className="mb-4">Your Answer</div>
      <Texteditor />
      <div className="flex justify-between">
        <button
          type="button"
          className="flex grow-0 mt-4 text-sm font-light bg-[#1e95ff] hover:bg-[#0074CC] text-white rounded-[4px] p-2"
        >
          Post Your Anwser
        </button>
      </div>
    </div>
  );
}

export default AnswerForm;
