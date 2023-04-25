import { useRef, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import UserLabel from '../ui/UserLabel';
import ButtonCard from '../ui/ButtonCard';
import { fetchLogin } from '../../api/login';

function LoginForm() {
  // eslint-disable-next-line
  const EMAIL_REGEX = /[\w\-\.]+\@[\w\-\.]+/g;
  const PW_REGEX = /^.{4,}$/;

  const [emailError, setEmailError] = useState(false);
  const [pwError, setPwError] = useState(false);
  const [error, setError] = useState('');

  const dispatch = useDispatch();
  const navigate = useNavigate();
  const emailRef = useRef(null);
  const pwRef = useRef(null);
  const loginState = useSelector(state => {
    return state.login.status;
  });

  const onLoginHandler = async e => {
    e.preventDefault();
    setEmailError(false);
    setPwError(false);
    setError('');

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

    emailRef.current.value = '';
    pwRef.current.value = '';

    // ! : 매게변수 전달할 때는 괄호로 감싸서 하나의 객체로 보내야 함.
    dispatch(fetchLogin({ email, pw }));
    if (loginState) {
      console.log('success');
      // 토큰으로 유저 정보 받아오기
      // fetch로 요청하기
      // 메인화면으로 redirect
      navigate('/');
    } else {
      // 로그인 실패
      setError('No corresponding user information found');
    }
  };
  return (
    <form className="flex flex-col border-solid w-72 border-slate-300 bg-white rounded my-4 p-5 justify-between shadow-xl">
      <UserLabel
        inputId="email"
        errorMsg="The email is not a valid email address."
        className="w-60 h-8 mt-1"
        inputRef={emailRef}
        state={emailError}
      >
        Email
      </UserLabel>
      <UserLabel
        errorMsg="Password cannot be empty."
        inputId="password"
        className="w-60 h-8 mt-1"
        inputRef={pwRef}
        state={pwError}
      >
        <p className="flex justify-between items-end w-60">
          Password
          <a href="http://#" className="font-thin text-xs text-sky-800">
            Forgot password?
          </a>
        </p>
      </UserLabel>
      <p className="mt-3 font-light text-xs text-red-600 text-center">{error}</p>
      <ButtonCard
        type="submit"
        className="w-60 h-10 mt-3 bg-[#1e95ff] hover:bg-[#0074CC] text-white"
        onClickHandler={onLoginHandler}
      >
        Log in
      </ButtonCard>
    </form>
  );
}

export default LoginForm;
