import { createBrowserRouter } from 'react-router-dom';

import QuestionPage from './pages/QuestionPage';
import AskQuestionPage from './pages/AskQuestionPage';
import Home from './pages/Home';
import QuestionDetailPage from './pages/QuestionDetailPage';
import UserPage from './pages/UserPage';
import LoginPage from './pages/LoginPage';
import SignUpPage from './pages/SignUpPage';
import ErrorPage from './pages/ErrorPage';

const questionRouters = [
  {
    path: '/questions',
    label: '전체 질문 페이지',
    element: <QuestionPage />,
  },
  {
    path: '/questions/new',
    label: '질문 생성 페이지',
    element: <AskQuestionPage />,
  },
  {
    path: '/questions/:questionId',
    label: '질문 상세 페이지',
    element: <QuestionDetailPage />,
  },
];

const userRouters = [
  {
    path: '/user',
    label: '회원 페이지',
    element: <UserPage />,
  },
  {
    path: '/user/login',
    label: '로그인 페이지',
    element: <LoginPage />,
  },
  {
    path: '/user/signup',
    label: '회원가입 페이지',
    element: <SignUpPage />,
  },
];

const routers = createBrowserRouter([
  {
    path: '/',
    label: '홈페이지',
    element: <Home />,
    errorElement: <ErrorPage />,
    children: [...questionRouters, ...userRouters],
  },
]);

export default routers;
