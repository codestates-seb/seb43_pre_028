import AskQuestion from '../components/askQuestion/AskQuestion';
import Main from '../components/layout/main/Main';

function AskQuestionPage() {
  return (
    <div className="flex w-full max-w-[1265px] mt-[50px] mx-auto">
      <Main>
        <AskQuestion />
      </Main>
    </div>
  );
}

export default AskQuestionPage;
