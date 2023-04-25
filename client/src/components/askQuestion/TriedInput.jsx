import TextEditor from './TextEditor';

function TriedInput() {
  return (
    <form className="max-w-7xl border-solid border-2 border-slate-400 mb-5 rounded-md p-8">
      <div>
        <h3 className="text-lg font-semibold">
          What did you try and what were you expecting?
        </h3>
        <p className="text-sm my-1">
          Describe what you tried, what you expected to happen, and what actually
          resulted. Minimum 20 characters.
        </p>
      </div>
      <div>
        <TextEditor />
      </div>
    </form>
  );
}

export default TriedInput;
