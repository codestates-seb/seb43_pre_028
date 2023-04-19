import Footer from './layout/footer/Footer';
import Header from './layout/header/Header';
import Main from './layout/main/Main';
// import AskQuestionPage from '../pages/AskQuestionPage';
import QuestionPage from '../pages/QuestionPage';
import LoginPage from '../pages/LoginPage';
import Question from './question/Question';
import SignUpPage from '../pages/SignUpPage';
import AskQuestionPage from '../pages/AskQuestionPage';

function App() {
  return (
    <div className="flex flex-col justify-center w-screen">
      <Header />
      <div className="flex max-w-[1265px] mt-[50px] mx-auto w-full">
        <Main>
          <AskQuestionPage />
        </Main>
      </div>
      <Footer />
    </div>
    // <SignUpPage />
  );
}

export default App;
