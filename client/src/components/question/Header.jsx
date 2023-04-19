import HeaderNav from './HeaderNav';
import Title from './Title';

function Header() {
  return (
    <div className="main-header pl-7 flex flex-col">
      <Title />
      <HeaderNav />
    </div>
  );
}

export default Header;
