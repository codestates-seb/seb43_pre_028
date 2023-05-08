import { useSelector } from 'react-redux';
import { Link } from 'react-router-dom';

function Title() {
  const isLogin = useSelector(state => state.login.status);
  return (
    <div className="flex justify-between items-center pb-5">
      <h1 className="text-[27px] text-black">All Questions</h1>
      {/* 로그인 유무에 따라 질문 작성 / 로그인 으로 분기 나뉨 */}
      <Link to={isLogin ? '/questions/new' : '/user/login'}>
        <button
          type="button"
          className="bg-[#1e95ff] hover:bg-[#0074CC] text-white rounded-[4px] p-[10px] text-[13px]"
        >
          Ask Question
        </button>
      </Link>
    </div>
  );
}

export default Title;
