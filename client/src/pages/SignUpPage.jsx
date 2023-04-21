import Header from '../components/layout/header/Header';
import SignUp from '../components/signup/SignUp';

function SignUpPage() {
  return (
    <div className="flex flex-col justify-center w-screen">
      <Header />
      <SignUp />
    </div>
  );
}

export default SignUpPage;
