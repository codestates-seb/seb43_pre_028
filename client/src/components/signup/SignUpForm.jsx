import { useRef, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import UserInput from '../ui/UserLabel';
import ButtonCard from '../ui/ButtonCard';
import { fetchSignUP } from '../../api/signup';

function SignUpForm() {
  // eslint-disable-next-line
  const EMAIL_REGEX = /[\w\-\.]+\@[\w\-\.]+/g;
  const PW_REGEX = /^.{4,}$/;

  const [emailError, setEmailError] = useState(false);
  const [pwError, setPwError] = useState(false);
  const [error, setError] = useState('');

  const dispatch = useDispatch();
  const navigate = useNavigate();
  const nameRef = useRef(null);
  const emailRef = useRef(null);
  const pwRef = useRef(null);
  const signupState = useSelector(state => {
    return state.signup.state;
  });
  const onSignUpHandler = async e => {
    e.preventDefault();

    setEmailError(false);
    setPwError(false);
    setError('');

    const name = nameRef.current.value;
    const email = emailRef.current.value;
    const pw = pwRef.current.value;

    if (!EMAIL_REGEX.test(email)) {
      // console.log('email');
      setEmailError(true);
      return;
    }
    if (!PW_REGEX.test(pw)) {
      setPwError(true);
      return;
    }

    nameRef.current.value = '';
    emailRef.current.value = '';
    pwRef.current.value = '';

    dispatch(fetchSignUP({ name, email, pw }));

    if (signupState) {
      navigate('/user/login');
    } else {
      // 에러 표시 하기
      // console.log('error!!');
      setError('An error has occurred');
    }
  };
  return (
    <form className="flex flex-col h-auto border-solid w-72 border-slate-300 bg-white rounded my-4 p-5 justify-between shadow-xl">
      <UserInput inputRef={nameRef} inputId="name" className="w-60 h-8 mt-1">
        Display name
      </UserInput>
      <UserInput
        inputRef={emailRef}
        inputId="email"
        className="w-60 h-8 mt-1"
        errorMsg="This is not a valid email address."
        state={emailError}
      >
        Email
      </UserInput>
      <UserInput
        inputRef={pwRef}
        inputId="password"
        className="w-60 h-8 mt-1"
        errorMsg="Please write your password in at least 4 letters."
        state={pwError}
      >
        <p className="flex justify-between items-end w-60">Password</p>
      </UserInput>
      <p className="text-xs font-light">
        Passwords must contain at least eight characters, including at least 1 letter and
        1 number.
      </p>
      <p className="mt-8 font-light text-xs text-red-600 text-center">{error}</p>
      <ButtonCard
        type="submit"
        className="w-60 h-10 bg-[#1e95ff] hover:bg-[#0074CC] text-white mb-8"
        onClickHandler={onSignUpHandler}
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
