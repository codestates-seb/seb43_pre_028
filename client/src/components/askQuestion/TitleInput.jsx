function TitleInput() {
  return (
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
  );
}

export default TitleInput;
