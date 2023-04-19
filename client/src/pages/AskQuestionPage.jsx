import React from 'react';
import { ReactComponent as QuestionBg } from '../assets/img/questionCreateBg.svg';

function AskQuestionPage() {
  return (
    <div className="flex w-full flex-col p-10 mt-6 ">
      <div className="flex justify-between items-center mb-7 ">
        <h1 className="text-4xl font-semiold">Ask a public question</h1>
        <QuestionBg />
      </div>

      <div className="bg-[#EBF4FB] border-solid border-2 border-[#1e95ff] mb-5 rounded-md p-6 max-w-7xl">
        <div>
          <h2 className=" text-2xl mb-3">Writing a good question</h2>
          <div>
            You are ready to ask a programming-related question and this form will help
            guide you through the process.
          </div>
          <div className=" mb-3">
            Looking to ask a non-programming question? See the topics here to find a
            relevant site.
          </div>
          <h5 className="font-semibold">Steps</h5>
          <ul className="list-disc list-inside ml-4 mt-2">
            <li>Summarize your problem in a one-line title.</li>
            <li>Describe your problem in more detail.</li>
            <li>Describe what you tried and what you expected to happen.</li>
            <li>Review your question and post it to the site.</li>
          </ul>
        </div>
      </div>

      <div className=" max-w-7xl border-solid border-2 border-slate-400 mb-5 rounded-md p-8">
        <h3 className="text-lg font-semibold">Title</h3>
        <p className="text-sm my-1">
          Be specific and imagine you’re asking a question to another person.
        </p>
        <input
          id="title"
          name="title"
          type="text"
          maxLength="300"
          placeholder="e.g Is there an R function for finding the index of an element in a vector?"
          className="w-full py-2 px-3 border border-gray-300 rounded-md focus:outline-none focus:ring-1 focus:ring-blue-400 focus:border-blue-400"
        />
        <button
          type="button"
          className="flex bg-[#1e95ff] hover:bg-[#0074CC] text-white rounded-[4px] p-2 h-[36px] gap-1 mt-2"
        >
          Next
        </button>
      </div>

      <form className="max-w-7xl border-solid border-2 border-slate-400 mb-5 rounded-md p-8">
        <div>
          <h3 className="text-lg font-semibold">What are the details of your problem?</h3>
          <p className="text-sm my-1">
            Introduce the problem and expand on what you put in the title. Minimum 20
            characters.
          </p>
        </div>
        <div className="h-64 w-full bg-[#7cc6fe]">StackEdit</div>
      </form>
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
        <div className="h-64 w-full bg-[#7cc6fe]">StackEdit</div>
      </form>
      <button
        type="button"
        className="flex bg-[#1e95ff] hover:bg-[#0074CC] text-white rounded-[4px] p-2 h-[36px] w-fit gap-1 mt-2"
      >
        Put your question
      </button>
    </div>
  );
}

export default AskQuestionPage;

// text-lg
