import { FacebookIcon, GithubIcon, GoogleIcon } from '../Icons';
import ButtonCard from '../ui/ButtonCard';

// * : OAuth 로그인/회원가입 버튼 묶음
// * : where : "log in" / "sign up"

// ? : components 폴더에 넣는게 좋을지.
// ? : OAuth의 로그인과 회원가입이 같은 코드로 이루어지는지 확인 필요(추후 변동가능성 있음)
function OAuthPart({ where }) {
  return (
    <div className="flex flex-col">
      <ButtonCard className="border-slate-300 w-72 h-10 p-2 my-1 bg-white hover:bg-slate-50">
        <GoogleIcon className="w-4 h-4 mr-1" />
        {where} with Google
      </ButtonCard>
      <ButtonCard className="w-72 h-10 p-2 my-1 bg-slate-800 text-white hover:bg-slate-900">
        <GithubIcon className="w-4 h-4 mr-1" />
        {where} with GitHub
      </ButtonCard>
      <ButtonCard className="border-slate-300 w-72 h-10 p-2 my-1 bg-blue-800 text-white hover:bg-blue-900">
        <FacebookIcon className="w-4 h-4 mr-1" />
        {where} with Facebook
      </ButtonCard>
    </div>
  );
}

export default OAuthPart;
