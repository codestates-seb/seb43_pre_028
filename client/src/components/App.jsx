import Footer from './layout/footer/Footer';
import Header from './layout/header/Header';
import Main from './layout/main/Main';
import AskQuestionPage from '../pages/QuestionPage1';

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
  );
}

export default App;
