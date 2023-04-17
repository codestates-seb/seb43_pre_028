import './App.css';
import Footer from './layout/footer/Footer';
import Header from './layout/header/Header';
import Aside from './layout/aside/Aside';

function App() {
  return (
    <div className="App">
      {/* eslint-disable-next-line prettier/prettier */}
      <h1 className="flex h-20 w-20 border-collapse items-center justify-center">
        implement Footer
      </h1>
      <Footer />
      <Header />
      <Aside />
    </div>
  );
}

export default App;
