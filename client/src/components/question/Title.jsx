import { Link } from 'react-router-dom';

function Title() {
  return (
    <div className="flex justify-between items-center pb-5">
      <h1 className="text-[27px] text-black">All Questions</h1>
      <Link to="/questions/new">
        <button
          type="button"
          className="bg-[#1e95ff] hover:bg-[#0074CC] text-white rounded-[4px] p-[10px] text-[13px]"
        >
          Ask Question
        </button>
      </Link>
    </div>
  );
}

export default Title;
