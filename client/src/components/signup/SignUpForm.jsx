import UserInput from '../ui/UserLabel';
import ButtonCard from '../ui/ButtonCard';

function SignUpForm() {
  return (
    <form className="flex flex-col h-auto border-solid w-72 border-slate-300 bg-white rounded my-4 p-5 justify-between shadow-xl">
      <UserInput inputId="name" className="w-60 h-8 mt-1">
        Display name
      </UserInput>
      <UserInput inputId="email" className="w-60 h-8 mt-1">
        Email
      </UserInput>
      <UserInput inputId="password" className="w-60 h-8 mt-1">
        <p className="flex justify-between items-end w-60">Password</p>
      </UserInput>
      <p className="text-xs font-light">
        Passwords must contain at least eight characters, including at least 1 letter and
        1 number.
      </p>
      <ButtonCard
        type="submit"
        className="w-60 h-10 bg-[#1e95ff] hover:bg-[#0074CC] text-white my-8"
      >
        Sign up
      </ButtonCard>
      <p className="text-xs font-light">
        By clicking “Sign up”, you agree to our{' '}
        <a href="http://#" className="text-sky-800 hover:text-sky-600">
          terms of service
        </a>
        ,
        <a href="http://#" className="text-sky-800 hover:text-sky-600">
          privacy policy and
        </a>
        <a href="http://#" className="text-sky-800 hover:text-sky-600">
          cookie policy
        </a>
      </p>
    </form>
  );
}

export default SignUpForm;
