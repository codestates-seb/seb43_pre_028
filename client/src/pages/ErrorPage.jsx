import { PageNotFoundLogo } from '../components/Icons';
import Header from '../components/layout/header/Header';

function ErrorPage() {
  return (
    <>
      <Header />
      <div className="flex justify-center items-center w-screen h-screen p-6 bg-[#f1f2f3] text-[#232629] text-[15px]">
        <PageNotFoundLogo className="relative top-[-40px] left-[-20px]" />
        <div className="p-4">
          <h1 className="text-[27px] font-normal">Page not found</h1>
          <div className="text-[19px] py-2 mb-2">
            <p>We&apos;re sorry, we couldn&apos;t find the page you requested.</p>
          </div>
          <div className="flex flex-col gap-4 ">
            <p>
              Try{' '}
              <span className="cursor-pointer text-[#4b91d5]">
                searching for similar questions
              </span>
            </p>
            <p>
              Browse our{' '}
              <span className="cursor-pointer text-[#4b91d5]">recent questions</span>
            </p>
            <p>
              Browse our{' '}
              <span className="cursor-pointer text-[#4b91d5]">popular tags</span>
            </p>
            <p>
              If you feel something is missing that should be here,{' '}
              <span className="cursor-pointer text-[#4b91d5]">contact us.</span>
            </p>
          </div>
        </div>
      </div>
    </>
  );
}

export default ErrorPage;
