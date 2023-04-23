import { useState } from 'react';
import { Link } from 'react-router-dom';
import { StackoverFlowLogo } from '../../Icons';

import Nav from './Nav';
import Search from './Search';
import LoginButtons from './LoginButtons';

function Header() {
  const [foucused, setFocused] = useState(false);

  return (
    <header className="flex fixed z-10 w-screen bg-[#F8F8F8] top-0 left-0 border-solid border-t-[3px] border-[#ef8236] shadow-md text-[13px] text-nav-color font-normal">
      <div className="flex items-center justify-center w-[1265px] max-w-[1265px] mx-auto">
        <Link to="/">
          <StackoverFlowLogo />
        </Link>
        <Nav />
        <Search />
        <LoginButtons />
      </div>
    </header>
  );
}

export default Header;
