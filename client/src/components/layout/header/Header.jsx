import React from 'react';
import { ReactComponent as StackoverFlowSVG } from '../../../assets/img/searchIcon.svg';

function Header() {
  return (
    <header className="fixed top-0 left-0 w-full bg-white shadow-md flex items-center justify-between px-4 py-2">
      <div className="flex items-center">
        <StackoverFlowSVG />

        <input type="text" placeholder="Search" className=" rounded-sm px-3 py-1" />
      </div>
      <nav className="flex justify-end">
        <p className="text-gray-600 hover:text-gray-800 mr-4 cursor-pointer">About</p>
        <p className="text-gray-600 hover:text-gray-800 mr-4 cursor-pointer">Products</p>
        <p className="text-gray-600 hover:text-gray-800 mr-4 cursor-pointer">For Teams</p>
      </nav>
      <button type="button" className="bg-#B3D3EA cursor-pointer">
        Login
      </button>
      <button type="button" className="bg-#0074CC cursor-pointer">
        Sign up
      </button>
      {/* <button>Sign up</button> */}
    </header>
  );
}

export default Header;
