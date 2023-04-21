import { Outlet, useLocation } from 'react-router-dom';

import Header from '../components/layout/header/Header';
import Footer from '../components/layout/footer/Footer';
import QuestionPage from './QuestionPage';

function Home() {
  const { pathname } = useLocation();
  const isFooterExist = !['/user/login', '/user/signup'].includes(pathname);

  return (
    <div className="flex flex-col justify-center w-screen">
      <Header />
      {pathname === '/' && <QuestionPage />}
      <Outlet />
      {isFooterExist && <Footer />}
    </div>
  );
}

export default Home;
