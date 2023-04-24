// TODO : 에러메세지 표시
// TODO : 입력된 데이터 처리

// * : 로그인과 회원가입의 인풋창 공통 속성 UI
import { useState } from 'react';

function UserLabel({ children, inputId, className, errorMsg, inputRef }) {
  const [errorMessage, setErrorMessage] = useState('');
  return (
    <label htmlFor={inputId} className="flex flex-col my-1">
      {children}
      <input
        id={inputId}
        className={`border border-slate-400 rounded focus:border-blue-800 focus:outline-0 box-border p-2 font-light text-xs ${className}`}
        ref={inputRef}
      />
      <p className="font-light text-xs text-red-600">{errorMessage}</p>
    </label>
  );
}

export default UserLabel;
