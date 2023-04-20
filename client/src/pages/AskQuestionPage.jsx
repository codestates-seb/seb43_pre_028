import React from 'react';
import AskQuestion from '../components/askQuestion/AskQuestion';
import Header from '../components/layout/header/Header';
import Main from '../components/layout/main/Main';
import Footer from '../components/layout/footer/Footer';

function AskQuestionPage() {
  return (
    <div className="flex flex-col justify-center w-screen">
      <Header />
      <div className="flex max-w-[1265px] mt-[50px] mx-auto w-full">
        <Main>
          <AskQuestion />
        </Main>
      </div>
      <Footer />
    </div>
  );
}

export default AskQuestionPage;
