import { useRef, useState } from 'react';
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import UserLabel from '../ui/UserLabel';
import ButtonCard from '../ui/ButtonCard';
import { setStatus } from '../../store/loginSlice';
import { fetchUser } from '../../api/user';

const BASE_URL = process.env.REACT_APP_BASE_URL;
function LoginForm() {
  // eslint-disable-next-line
  const EMAIL_REGEX = /[\w\-\.]+\@[\w\-\.]+/g;
  const PW_REGEX = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,20}$/;

  const [emailError, setEmailError] = useState(false);
  const [pwError, setPwError] = useState(false);
  const [error, setError] = useState('');

  const dispatch = useDispatch();
  const navigate = useNavigate();
  const emailRef = useRef(null);
  const pwRef = useRef(null);

  const onLoginHandler = async e => {
    e.preventDefault();
    setEmailError(false);
    setPwError(false);
    setError('');

    const email = emailRef.current.value;
    const password = pwRef.current.value;

    if (!EMAIL_REGEX.test(email)) {
      // console.log('email');
      setEmailError(true);
      return;
    }
    if (!PW_REGEX.test(password)) {
      setPwError(true);
      return;
    }

    // ! : 서버에서 데이터를 받아올 수 있게 되기 전까지 사용하는 임시 코드
    dispatch(setStatus(true));
    navigate('/');
    // ! : 유효성 검사 후 바로 로그인 상태로 변경(서버통신X)

    const url = `${BASE_URL}/v1/user/login`;
    await axios
      .post(url, { email, password })
      .then(res => {
        if (res.data.length > 0) {
          emailRef.current.value = '';
          pwRef.current.value = '';

          // * : res로 받아온 데이터(토큰) sessionStorage에 저장
          sessionStorage.setItem('token', res.data);
          // * : login 여부 수정 코드
          dispatch(setStatus(true));
          // * : 토큰을 받아서 유저 데이터를 받아오는 요청(userSlice에 유저 정보 저장)
          dispatch(fetchUser());

          navigate('/');
        } else {
          setError('No corresponding user information found');
        }
      })
      .catch(() => {
        setError('No corresponding user information found');
      });
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
        errorMsg="Please write 8 to 20 characters including upper case, lower case, special character, and number."
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
