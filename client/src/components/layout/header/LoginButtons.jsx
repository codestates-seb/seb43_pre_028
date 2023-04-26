import { useState } from 'react';
import { Link } from 'react-router-dom';
import { AchievementIcon, HelpIcon, InboxIcon, StackExchangeIcon } from '../../Icons';

function BeforeLogin() {
  return (
    <div className="flex ml-[6px] h-[36px]">
      <Link to="/user/login" className="flex">
        <button
          type="button"
          className="bg-[#e1ecf4] hover:bg-[#B3D3EA] text-[#39739d] border-[1px] border-[#b2cbdd] rounded-[4px] px-[10px]"
        >
          Login
        </button>
      </Link>

      <Link to="/user/signup" className="flex">
        <button
          type="button"
          className="ml-[6px] bg-[#1e95ff] hover:bg-[#0074CC] text-white rounded-[4px] px-[10px] w-[66px]"
        >
          Sign up
        </button>
      </Link>
    </div>
  );
}

function AfterLogin() {
  return (
    <div className="flex">
      <div className="flex items-center justify-between gap-4">
        <img
          src="https://lh3.googleusercontent.com/a/AGNmyxZ3yZ7RupMJPJCP_NwE0ngixsfdYY3OmIqScQmx=k-s32"
          alt="user-avartar"
          className="ml-4 mr-4 rounded-md h-[30px] w-[30px]"
        />
        <InboxIcon className="fill-[#525960] h-[28px] w-[28px]" />
        <AchievementIcon className="fill-[#525960] h-[28px] w-[28px]" />
        <HelpIcon className="fill-[#525960] h-[28px] w-[28px]" />
        <StackExchangeIcon className="fill-[#525960] h-[28px] w-[28px] mr-2" />
      </div>
    </div>
  );
}

function LoginButtons() {
  const [isLogin, setIsLogin] = useState(true);

  return (
    <>
      {isLogin && <AfterLogin />}
      {!isLogin && <BeforeLogin />}
    </>
  );
}

export default LoginButtons;
