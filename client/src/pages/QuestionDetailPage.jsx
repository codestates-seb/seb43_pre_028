import Nav from '../components/layout/nav/Nav';
import Main from '../components/layout/main/Main';
import Aside from '../components/question/Aside';
import QuestionDetail from '../components/questionDetail/QuestionDetail';

function QuestionDetailPage() {
  return (
    <div className="flex w-full max-w-[1265px] mt-[50px] mx-auto">
      <Nav />
      <Main>
        <QuestionDetail />
        <Aside />
      </Main>
    </div>
  );
}

export default QuestionDetailPage;
