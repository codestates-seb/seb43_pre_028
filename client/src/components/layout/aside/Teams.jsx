function Teams() {
  return (
    <>
      <div className="text-[11px] font-light mt-4 ml-2 mb-2">TEAMS</div>
      <div className="border-solid border-[1px] border-r-0 rounded-sm border-slate-300">
        <div className="p-2 font-normal">
          <strong className="font-bold text-black">Stack Overflow for Teams</strong> –
          Start collaborating and sharing organizational knowledge.
          <img
            src="https://cdn.sstatic.net/Img/teams/teams-illo-free-sidebar-promo.svg?v=47faa659a05e"
            alt="stackoverflow-team"
          />
          <div className="flex justify-center ">
            <button
              type="button"
              className="w-full bg-[#f48225] p-2 px-3 rounded-sm text-white text-[11px]"
            >
              Create a free Team
            </button>
          </div>
          <div className="flex justify-center ">
            <button
              type="button"
              className="w-full p-2 text-[11px] rounded-sm hover:bg-[#f8f9f9]"
            >
              Why Teams?
            </button>
          </div>
        </div>
      </div>
    </>
  );
}

export default Teams;
