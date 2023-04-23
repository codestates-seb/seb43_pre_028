function WritingGuide() {
  return (
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
  );
}

export default WritingGuide;
