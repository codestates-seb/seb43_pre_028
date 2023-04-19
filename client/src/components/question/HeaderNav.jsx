import { DownIcon, FilterIcon } from '../Icons';

function HeaderNav() {
  return (
    <div className="flex items-center justify-between pb-3">
      <div className="flex text-[17px]">23,655,476 questions</div>
      <div className="flex items-center">
        <nav className="flex items-center text-[12px]">
          <button
            type="button"
            className="px-[12px] py-2 border-solid border-[1px] border-nav-color rounded-l-[4px]"
          >
            Newest
          </button>
          <button
            type="button"
            className="px-[12px] py-2 border-solid border-[1px] border-nav-color border-l-0"
          >
            Active
          </button>
          <button
            type="button"
            className="px-[12px] py-2 border-solid border-[1px] border-nav-color border-l-0"
          >
            Bountied
          </button>
          <button
            type="button"
            className="px-[12px] py-2 border-solid border-[1px] border-nav-color border-l-0"
          >
            Unanswered
          </button>
          <button
            type="button"
            className="flex items-center px-[12px] py-2 border-solid border-[1px] border-nav-color border-l-0 rounded-r-[4px]"
          >
            More <DownIcon className="fill-black h-2 w-2 ml-1" />
          </button>
        </nav>
        <button
          type="button"
          className="ml-4 text-[11px] text-[#2c5877] bg-[#e1ecf4] hover:bg-[#B3D3EA] border-[1px] border-[#b2cbdd] rounded-[4px] p-[10px] py-2"
        >
          <FilterIcon className="inline fill-[#2c5877]" /> Filter
        </button>
      </div>
    </div>
  );
}

export default HeaderNav;
