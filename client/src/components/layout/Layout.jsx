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
        <div className="flex w-full  min-h-[70vh] max-w-[1265px] mt-[50px] mx-auto">
          {withNav && <Nav />}
          <Main>
            {children}
            {withAside && <Aside />}
          </Main>
        </div>
      )}
      {!withMain && children}

      {withFooter && <Footer />}
    </div>
  );
}

export default Layout;
