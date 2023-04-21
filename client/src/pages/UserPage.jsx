import Nav from '../components/layout/nav/Nav';
import Main from '../components/layout/main/Main';
import User from '../components/user/User';

function UserPage() {
  return (
    <div className="flex w-full max-w-[1265px] mt-[50px] mx-auto">
      <Nav />
      <Main>
        <User />
      </Main>
    </div>
  );
}

export default UserPage;
