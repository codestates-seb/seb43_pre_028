import React from 'react';

import ButtonCard from '../ui/ButtonCard';
import UserInput from '../ui/UserLabel';
import { LinkIcon } from './Icons';
import OAuthPart from '../login/OAuthPart';
import LeftContents from './LeftContents';

// TODO : 글자크기 제안하기
function SignUp() {
  return (
    <div className="flex justify-center items-center h-screen w-full bg-gray-100">
      <LeftContents />
      <div className="flex flex-col justify-center items-center">
        <OAuthPart where="Sign up" />
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
            Passwords must contain at least eight characters, including at least 1 letter
            and 1 number.
          </p>
          <ButtonCard
            type="submit"
            className="w-60 h-10 bg-blue-500 text-white hover:bg-blue-600 my-8"
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
            <LinkIcon />
          </a>
        </p>
      </div>
    </div>
  );
}

export default SignUp;
