import { SignUpLinkIcon } from '../Icons';
import OAuthPart from '../login/OAuthPart';
import LeftContents from './LeftContents';
import SignUpForm from './SignUpForm';

// TODO : 글자크기 제안하기
function SignUp() {
  return (
    <div className="flex justify-center items-center h-screen w-full bg-gray-100">
      <LeftContents />
      <div className="flex flex-col justify-center items-center">
        <h1 className="text-xl text-center mb-8 md:hidden">
          Create your Stack Overflow account. It’s free <br />
          and only takes a minute.
        </h1>
        <OAuthPart where="Sign up" />
        <SignUpForm />
        <p className="font-light text-xs my-1 mt-4">
          Already have an account?
          <a
            href="http://#"
            className="font-thin text-xs text-sky-800 ml-1 hover:text-sky-600"
          >
            Log in
          </a>
        </p>
        <p className="font-light text-xs my-1 flex">
          Are you an employer?
          <a
            href="http://#"
            className="flex items-end font-thin text-xs text-sky-800 ml-1 hover:text-sky-600 fill-sky-800 hover:fill-sky-600"
          >
            Sign up on Talent
            <SignUpLinkIcon className="ml-1" />
          </a>
        </p>
      </div>
    </div>
  );
}

export default SignUp;
