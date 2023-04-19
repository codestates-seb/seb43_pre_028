import { EarthIcon, InfoIcon, StarIcon } from '../../Icons';

function NavPageLinks() {
  return (
    <div className="flex flex-col w-full">
      <div className="mt-4 ml-2 mb-1 text-[11px]">PUBLIC</div>
      <div className="flex items-center pl-2 py-2 pr-1 text-black bg-[#F1F2F3] border-solid border-r-[3px] border-[#F48225]">
        <EarthIcon />
        <span className="flex items-center font-bold ml-1">Questions</span>
      </div>
      <div className="p-2 pl-[30px]">Tags</div>
      <div className="p-2 pl-[30px]">Users</div>
      <div className="p-2 pl-[30px]">Companies</div>
      <div className="flex justify-between mt-4 ml-2 pr-2 font-normal">
        COLLECTIVES
        <InfoIcon className="fill-slate-400 hover:fill-slate-800" />
      </div>
      <div className="flex justify-start p-2 pr-4 font-normal">
        <StarIcon className="fill-[#F48225]" />
        <span className="flex items-center ml-1">Explore Collectives</span>
      </div>
    </div>
  );
}

export default NavPageLinks;
