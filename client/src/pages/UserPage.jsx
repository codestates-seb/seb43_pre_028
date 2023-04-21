import Header from '../components/layout/header/Header';
import Nav from '../components/layout/nav/Nav';
import Main from '../components/layout/main/Main';
import Footer from '../components/layout/footer/Footer';
import User from '../components/user/User';

function UserPage() {
  return (
    <div className="flex flex-col justify-center w-screen">
      <Header />
      <div className="flex w-full max-w-[1265px] mt-[50px] mx-auto">
        <Nav />
        <Main>
          <User />
        </Main>
      </div>
      <Footer />
    </div>
  );
}

export default UserPage;