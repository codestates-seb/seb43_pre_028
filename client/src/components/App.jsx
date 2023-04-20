import { Route, Routes } from 'react-router-dom';

import QuestionPage from '../pages/QuestionPage';
import LoginPage from '../pages/LoginPage';
import SignUpPage from '../pages/SignUpPage';
import AskQuestionPage from '../pages/AskQuestionPage';
import Home from '../pages/Home';
import QuestionDetailPage from '../pages/QuestionDetailPage';
import UserPage from '../pages/UserPage';
import ErrorPage from '../pages/ErrorPage';

function App() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="home" element={<Home />} />
      <Route path="questions" element={<QuestionPage />} />
      <Route path="questions/new" element={<AskQuestionPage />} />
      <Route path="questions/detail" element={<QuestionDetailPage />} />
      <Route path="users/" element={<UserPage />} />
      <Route path="users/login" element={<LoginPage />} />
      <Route path="users/signup" element={<SignUpPage />} />
      <Route path="*" element={<ErrorPage />} />
    </Routes>
  );
}

export default App;
