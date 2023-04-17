import { EarthIcon, InfoIcon, StarIcon } from './Icons';

function Nav() {
  return (
    <div className="flex flex-col w-full">
      <div className="mt-4 ml-2 mb-1 text-[11px]">PUBLIC</div>
      <div className="flex pl-2 py-2 pr-1 text-black bg-[#F1F2F3] border-solid border-r-[3px] border-[#F48225]">
        <EarthIcon />
        <span className="font-semibold">Questions</span>
      </div>
      <div className="p-2 pl-[30px]">Tags</div>
      <div className="p-2 pl-[30px]">Users</div>
      <div className="p-2 pl-[30px]">Companies</div>
      <div className="flex justify-between mt-4 ml-2 pr-2 font-light">
        COLLECTIVES
        <InfoIcon />
      </div>
      <div className="flex justify-between p-2 pr-4 font-normal">
        <StarIcon />
        Explore Collectives
      </div>
    </div>
  );
}

export default Nav;
