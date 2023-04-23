import Main from './main/Main';
import Nav from './nav/Nav';
import Aside from './Aside';
import Header from './header/Header';
import Footer from './footer/Footer';

function Layout({ layoutInfo, children }) {
  const { withFooter, withNav, withMain, withAside } = layoutInfo;

  return (
    <div className="flex flex-col justify-center w-screen">
      <Header />

      {withMain && (
        <div className="flex w-full max-w-[1265px] mt-[50px] mx-auto">
          {withNav && <Nav />}
          <Main>
            {children}
            {withAside && <Aside />}
          </Main>
        </div>
      )}
      {/* login & signup page는 withMain이 없으므로 처리해주어야 rendering된다. */}
      {!withMain && children}

      {withFooter && <Footer />}
    </div>
  );
}

export default Layout;

// <div className="flex w-full max-w-[1265px] mt-[50px] mx-auto">
//   <Nav />
//   <Main>
//     <Question />
//     <Aside />
//   </Main>
// </div>;
