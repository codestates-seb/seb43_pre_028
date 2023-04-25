function LinksEdit() {
  return (
    <>
      <div className="mt-5 text-xl">Links</div>
      <div className="flex flex-col w-[390px] items-end md:flex-row border border-solid border-slate-300 bg-white rounded my-4 p-5 justify-between w-full">
        <label htmlFor="web" className="flex flex-col my-1 md:w-[30%] w-[390px]">
          Website link
          <input
            id="web"
            className="border border-slate-400 rounded focus:border-blue-800 focus:outline-0 box-border p-2 font-light text-xs mt-1"
          />
        </label>
        <label htmlFor="twitter" className="flex flex-col my-1 md:w-[30%] w-[390px]">
          Twitter link or username
          <input
            id="twitter"
            className="border border-slate-400 rounded focus:border-blue-800 focus:outline-0 box-border p-2 font-light text-xs mt-1"
          />
        </label>
        <label htmlFor="github" className="flex flex-col my-1 md:w-[30%] w-[390px]">
          GitHub link or username
          <input
            id="github"
            className="border border-slate-400 rounded focus:border-blue-800 focus:outline-0 box-border p-2 font-light text-xs mt-1"
          />
        </label>
      </div>
    </>
  );
}

export default LinksEdit;
