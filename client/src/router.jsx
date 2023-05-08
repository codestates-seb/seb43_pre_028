import { createBrowserRouter } from 'react-router-dom';

import ErrorPage from './pages/ErrorPage';
import Question from './components/question/Questions';
import AskQuestion from './components/askQuestion/AskQuestion';
import QuestionDetail from './components/questionDetail/QuestionDetail';
import SignUp from './components/signup/SignUp';
import Login from './components/login/Login';
import Layout from './components/layout/Layout';
import User from './components/user/User';

const questionRouters = [
  {
    path: '/questions',
    label: '전체 질문 페이지',
    element: <Question />,
    layoutInfo: {
      withNav: true,
      withMain: true,
      withAside: true,
      withFooter: true,
    },
  },
  {
    path: '/questions/new',
    label: '질문 생성 페이지',
    element: <AskQuestion />,
    layoutInfo: {
      withNav: false,
      withMain: true,
      withAside: false,
      withFooter: true,
    },
  },
  {
    path: '/questions/:questionId',
    label: '질문 상세 페이지',
    element: <QuestionDetail />,
    layoutInfo: {
      withNav: true,
      withMain: true,
      withAside: true,
      withFooter: true,
    },
  },
];

const userRouters = [
  {
    path: '/user',
    label: '회원 페이지',
    element: <User />,
    layoutInfo: {
      withNav: true,
      withMain: true,
      withAside: false,
      withFooter: true,
    },
  },
  {
    path: '/user/login',
    label: '로그인 페이지',
    element: <Login />,
    layoutInfo: {
      withNav: false,
      withMain: false,
      withAside: false,
      withFooter: false,
    },
  },
  {
    path: '/user/signup',
    label: '회원가입 페이지',
    element: <SignUp />,
    layoutInfo: {
      withNav: false,
      withMain: false,
      withAside: false,
      withFooter: false,
    },
  },
];

const tagsRouter = [
  {
    path: '/tags',
    label: 'tag 페이지',
    element: (
      <h1 className="w-full h-[70vh] flex justify-center items-center text-2xl">
        Tag Page
      </h1>
    ),
    layoutInfo: {
      withNav: true,
      withMain: true,
      withAside: false,
      withFooter: true,
    },
  },
];

const usersRouter = [
  {
    path: '/users',
    label: 'users 페이지',
    element: (
      <h1 className="w-full h-[70vh] flex justify-center items-center text-2xl">
        Users Page
      </h1>
    ),
    layoutInfo: {
      withNav: true,
      withMain: true,
      withAside: false,
      withFooter: true,
    },
  },
];

const companiesRouter = [
  {
    path: '/companies',
    label: '회사 페이지',
    element: (
      <h1 className="w-full h-[70vh] flex justify-center items-center text-2xl">
        Companies Page
      </h1>
    ),
    layoutInfo: {
      withNav: true,
      withMain: true,
      withAside: false,
      withFooter: true,
    },
  },
];

const routerData = [
  {
    path: '/',
    label: '홈페이지',
    element: <Question />,
    errorElement: <ErrorPage />,
    layoutInfo: {
      withNav: true,
      withMain: true,
      withAside: true,
      withFooter: true,
    },
  },
  ...questionRouters,
  ...userRouters,
  ...tagsRouter,
  ...usersRouter,
  ...companiesRouter,
];

const routers = createBrowserRouter(
  routerData.map(router => ({
    ...router,
    element: <Layout layoutInfo={router.layoutInfo}>{router.element}</Layout>,
  })),
);

export default routers;
