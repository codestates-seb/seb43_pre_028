import { useRef } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import UserLabel from '../ui/UserLabel';
import ButtonCard from '../ui/ButtonCard';
import { fetchLogin } from '../../api/login';

function LoginForm() {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const emailRef = useRef(null);
  const pwRef = useRef(null);
  const loginState = useSelector(state => {
    return state.login.state;
  });

  const onLoginHandler = async e => {
    e.preventDefault();
    const email = emailRef.current.value;
    const pw = pwRef.current.value;

    emailRef.current.value = '';
    pwRef.current.value = '';

    // ! : 매게변수 전달할 때는 괄호로 감싸서 하나의 객체로 보내야 함.
    dispatch(fetchLogin({ email, pw }));
    if (loginState) {
      console.log('success');
      // 토큰 저장
      // 토큰으로 유저 정보 받아오기
      // 메인화면으로 redirect
      navigate('/');
    } else {
      // 로그인 실패
    }

    // return axios
    //   .post('http://localhost:4000/login', { loginInfo, checkedKeepLogin })
    //   .then(res => {
    //   })
    //   .catch(err => {
    //   });
  };
  return (
    <form className="flex flex-col border-solid w-72 border-slate-300 bg-white rounded my-4 p-5 justify-between shadow-xl">
      <UserLabel
        inputId="email"
        errorMsg="The email is not a valid email address."
        className="w-60 h-8 mt-1"
        inputRef={emailRef}
        state={loginState}
      >
        Email
      </UserLabel>
      <UserLabel
        errorMsg="Password cannot be empty."
        inputId="password"
        className="w-60 h-8 mt-1"
        inputRef={pwRef}
        state={loginState}
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
        onClickHandler={onLoginHandler}
      >
        Log in
      </ButtonCard>
    </form>
  );
}

export default LoginForm;
