import React from 'react';
import UserLabel from '../../components/ui/UserLabel';
import ButtonCard from '../../components/ui/ButtonCard';

function LoginForm() {
  return (
    <form className="flex flex-col border-solid w-72 border-slate-300 bg-white rounded my-4 p-5 justify-between shadow-xl">
      <UserLabel
        inputId="email"
        errorMsg="The email is not a valid email address."
        className="w-60 h-8 mt-1"
      >
        Email
      </UserLabel>
      <UserLabel
        errorMsg="Password cannot be empty."
        inputId="password"
        className="w-60 h-8 mt-1"
      >
        <p className="flex justify-between items-end w-60">
          Password
          <a href="http://#" className="font-thin text-xs text-sky-800">
            Forgot password?
          </a>
        </p>
      </UserLabel>
      <ButtonCard
        type="submit"
        className="w-60 h-10 mt-3 bg-[#1e95ff] hover:bg-[#0074CC] text-white"
      >
        Log in
      </ButtonCard>
    </form>
  );
}

export default LoginForm;
