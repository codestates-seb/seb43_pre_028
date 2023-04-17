import './App.css';
import Footer from './layout/footer/Footer';
import Header from './layout/header/Header';
import Aside from './layout/aside/Aside';

function App() {
  return (
    <>
      <Header />
      <div className="App flex justify-center w-screen">
        {/* eslint-disable-next-line prettier/prettier */}
        <div className="relative w-[1260px] max-w-[1260px] mt-[50px] mx-auto">
          <Aside />
          <main className="pl-[164px] w-full">
            <div className="h-[400px] text-white bg-black">div1</div>
            <div className="h-[400px] text-white bg-slate-200">div2</div>
            <div className="h-[400px] text-white bg-slate-400">div3</div>
            <div className="h-[400px] text-white bg-slate-600">div4</div>
            <div className="h-[400px] text-white bg-slate-900">div5</div>
          </main>
        </div>
      </div>
    </>
  );
}

export default App;
