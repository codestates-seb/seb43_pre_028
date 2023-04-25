import { useRef } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import UserInput from '../ui/UserLabel';
import ButtonCard from '../ui/ButtonCard';
import { fetchSignUP } from '../../api/signup';

function SignUpForm() {
  const BASE_URL = 'localhost:8080';
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
    const name = nameRef.current.value;
    const email = emailRef.current.value;
    const pw = pwRef.current.value;

    nameRef.current.value = '';
    emailRef.current.value = '';
    pwRef.current.value = '';

    dispatch(fetchSignUP({ name, email, pw, BASE_URL }));

    if (signupState) {
      navigate('/user/login');
    } else {
      console.log('error!!');
    }

    // return axios
    //   .post('http://localhost:4000/login', { loginInfo, checkedKeepLogin })
    //   .then(res => {
    //   })
    //   .catch(err => {
    //   });
  };
  return (
    <form className="flex flex-col h-auto border-solid w-72 border-slate-300 bg-white rounded my-4 p-5 justify-between shadow-xl">
      <UserInput inputRef={nameRef} inputId="name" className="w-60 h-8 mt-1">
        Display name
      </UserInput>
      <UserInput inputRef={emailRef} inputId="email" className="w-60 h-8 mt-1">
        Email
      </UserInput>
      <UserInput inputRef={pwRef} inputId="password" className="w-60 h-8 mt-1">
        <p className="flex justify-between items-end w-60">Password</p>
      </UserInput>
      <p className="text-xs font-light">
        Passwords must contain at least eight characters, including at least 1 letter and
        1 number.
      </p>
      <ButtonCard
        type="submit"
        className="w-60 h-10 bg-[#1e95ff] hover:bg-[#0074CC] text-white my-8"
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
