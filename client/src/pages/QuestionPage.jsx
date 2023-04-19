import Header from '../components/layout/header/Header';
import Nav from '../components/layout/nav/Nav';
import Main from '../components/layout/main/Main';
import Question from '../components/question/Question';
import Footer from '../components/layout/footer/Footer';
import Aside from '../components/question/Aside';

function QuestionPage() {
  return (
    <div className="flex flex-col justify-center w-screen">
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

// 지현 회원정보수정페이지 구현
// 승주님은 템플릿에 맞게끔 flex로 짜기
// 혜미님 component 쪼개고 작명신경쓰고 stack editor 추가
// 나: router-dom, page template만들기, line-clamp plugin, icons 공통적, 공통적속성빼기
