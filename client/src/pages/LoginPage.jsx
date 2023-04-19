import Header from '../components/layout/header/Header';
import Login from '../components/login/Login';

function LoginPage() {
  return (
    <div className="flex flex-col justify-center w-screen">
      <Header />
      <Login />
    </div>
  );
}

export default LoginPage;
