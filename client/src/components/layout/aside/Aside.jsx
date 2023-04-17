import React from 'react';
import { ReactComponent as StackoverFlowSVG } from '../../../assets/img/question.svg';

function Aside() {
  return (
    <aside className="sticky w-48 sm:block hidden text-font-gray border border-r-line-gra border-l-0 border-solid">
      <div className="flex flex-col bg-grey">
        <span className="my-7 pl-3 text-sm text-bold cursor-pointer hover:text-black">
          Home
        </span>
        <span className="my-7 pl-3 text-sm cursor-pointer">PUBLIC</span>
        <ul>
          <li className="flex items-center h-12 w-48 text-sm font-bold bg-main-gray text-black border-2 border-r-orange-500 cursor-pointer">
            <StackoverFlowSVG />
            <div className="">Questions</div>
          </li>
          <div className="my-7 pl-3 text-sm text-bold cursor-pointer">Tags</div>
          <div className="my-7 pl-3 text-sm text-bold cursor-pointer">Users</div>
          <div className="my-7 pl-3 text-sm text-bold cursor-pointer">Companies</div>
          <li className="flex justify-between text-sm h-10 w-48 pt-3 ">
            <div className="my-1 pl-3 text-xs">COLLECTIVES</div>
          </li>
          <li className="flex text-sm h-10 w-48 cursor-pointer hover:text-black">
            <div>Explore Collectives</div>
          </li>

          <li className="flex justify-between text-sm h-10 w-48 pt-3 ">
            <div className="my-1 pl-3 text-xs">TEAM</div>
          </li>
          <li className="flex text-sm h-10 w-48 cursor-pointer hover:text-black">
            <div>Create free Team</div>
          </li>
        </ul>
      </div>
    </aside>
  );
}

export default Aside;
