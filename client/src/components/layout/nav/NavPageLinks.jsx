import { NavLink } from 'react-router-dom';
import { EarthIcon, InfoIcon, StarIcon } from '../../Icons';

function NavPageLinks() {
  const activedStyle =
    'p-2 pl-[30px] text-black bg-[#F1F2F3] border-solid border-r-[3px] border-[#F48225] font-bold';
  const notActivedStyle = 'p-2 pl-[30px]';

  const activedClassName = ({ isActive }) => (isActive ? activedStyle : notActivedStyle);

  return (
    <div className="flex flex-col w-full">
      <NavLink
        to="/"
        // className="flex justify-start pl-2 py-1 pr-1 font-medium text-[14px]"
        className={props =>
          `${activedClassName(props)} flex items-center pl-[8px] py-2 pr-1`
        }
      >
        Home
      </NavLink>
      <div className="mt-4 ml-2 mb-1 text-[11px]">PUBLIC</div>

      <NavLink
        to="/questions"
        className={props =>
          `${activedClassName(props)} flex items-center pl-[8px] py-2 pr-1`
        }
      >
        <div className="flex">
          <EarthIcon />
          <span className="flex items-center ml-1">Questions</span>
        </div>
      </NavLink>
      <NavLink to="/tags" className={activedClassName}>
        Tags
      </NavLink>
      <NavLink to="/users" className={activedClassName}>
        Users
      </NavLink>
      <NavLink to="/companies" className={activedClassName}>
        Companies
      </NavLink>
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
