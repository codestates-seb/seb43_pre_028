import TextEditor from './TextEditor';

function ProblemInput() {
  return (
    <form className="max-w-7xl border-solid border-2 border-slate-400 mb-5 rounded-md p-8">
      <div>
        <h3 className="text-lg font-semibold">What are the details of your problem?</h3>
        <p className="text-sm my-1">
          Introduce the problem and expand on what you put in the title. Minimum 20
          characters.
        </p>
      </div>
      <div>
        <TextEditor />
      </div>
    </form>
  );
}

export default ProblemInput;
