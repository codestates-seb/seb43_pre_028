import NavPageLinks from './NavPageLinks';
import Teams from './Teams';

function Nav() {
  return (
    <nav>
      <div className="sticky top-[50px] flex flex-col w-[164px] text-[13px] pt-8 text-nav-color font-normal border-solid border-r-[1px] border-slate-300 overflow-y-auto">
        <NavPageLinks />
        <Teams />
      </div>
    </nav>
  );
}

export default Nav;
