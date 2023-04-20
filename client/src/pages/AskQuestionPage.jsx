import React from 'react';
import AskQuestion from '../components/askQuestion/AskQuestion';
import Header from '../components/layout/header/Header';
import Footer from '../components/layout/footer/Footer';

function AskQuestionPage() {
  return (
    <div className="flex flex-col justify-center w-screen">
      <Header />
      <AskQuestion />
      <Footer />
    </div>
  );
}

export default AskQuestionPage;
