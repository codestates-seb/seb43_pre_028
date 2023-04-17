import { ReactComponent as Hamburger } from '../../../assets/img/hamburger.svg';
import { ReactComponent as Search } from '../../../assets/img/searchIcon.svg';

function HamburgerIcon() {
  return (
    <div className="flex justify-center items-center w-12 h-12">
      <Hamburger />
    </div>
  );
}

function StackoverFlowLogo() {
  return (
    <div className="px-2 py-[6px] min-w-[164px] w-[166px] h-[47px] text-white">
      <div className="bg-sprites bg-logo w-full h-full bg-no-repeat" />;
    </div>
  );
}

function SearchIcon() {
  return <Search />;
}

export { HamburgerIcon, StackoverFlowLogo, SearchIcon };
export default {};
