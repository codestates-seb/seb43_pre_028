import { Route, Routes } from 'react-router-dom';
import Footer from './layout/footer/Footer';
import Header from './layout/header/Header';
import Main from './layout/main/Main';
import QuestionPage from '../pages/QuestionPage';
import LoginPage from '../pages/LoginPage';
import SignUpPage from '../pages/SignUpPage';
import AskQuestionPage from '../pages/AskQuestionPage';
import Home from '../pages/Home';
import QuestionDetail from './QuestionDetail';

function App() {
  return (
    // <Routes>
    //   <Route path="/" element={<QuestionPage />}>
    //     <Route path="questions" element={<SignUpPage />} />
    //   </Route>
    // </Routes>
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="home" element={<Home />} />
      <Route path="questions" element={<QuestionPage />} />
      <Route
        path="questions/new"
        element={
          <div className="flex flex-col justify-center w-screen">
            <Header />
            <div className="flex max-w-[1265px] mt-[50px] mx-auto w-full">
              <Main>
                <AskQuestionPage />
              </Main>
            </div>
            <Footer />
          </div>
        }
      />
      <Route path="questions/detail" element={<QuestionDetail />} />
      <Route path="users/login" element={<LoginPage />} />
      <Route path="users/signup" element={<SignUpPage />} />
    </Routes>
  );
}

export default App;

// <div className="flex flex-col justify-center w-screen">
//   <Header />
//   <div className="flex max-w-[1265px] mt-[50px] mx-auto w-full">
//     <Main>
//       <AskQuestionPage />
//     </Main>
//   </div>
//   <Footer />
// </div>;
// {/* <SignUpPage /> */}
