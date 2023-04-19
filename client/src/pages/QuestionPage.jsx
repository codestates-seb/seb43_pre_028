import Header from '../components/layout/header/Header';
import Nav from '../components/layout/nav/Nav';
import Main from '../components/layout/main/Main';
import Question from '../components/question/Question';
import Footer from '../components/layout/footer/Footer';
import Aside from '../components/question/Aside';

function QuestionPage() {
  return (
    <div className="flex flex-col justify-center w-screen">
      {/* <Outlet /> */}
      <Header />
      <div className="flex w-full max-w-[1265px] mt-[50px] mx-auto">
        <Nav />
        <Main>
          <Question />
          <Aside />
        </Main>
      </div>
      <Footer />
    </div>
  );
}

export default QuestionPage;
