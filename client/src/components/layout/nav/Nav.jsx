import NavPageLinks from './NavPageLinks';
import Teams from './Teams';

function Nav() {
  return (
    <nav>
      <div className="sticky top-[50px] flex flex-col w-[164px] text-[13px] pt-8 text-nav-color font-normal border-solid border-r-[1px] border-slate-300 overflow-y-auto">
        <div
          type="button"
          className="flex justify-start pl-2 py-1 pr-1 font-medium text-[14px]"
        >
          Home
        </div>
        <NavPageLinks />
        <Teams />
      </div>
    </nav>
  );
}

export default Nav;
