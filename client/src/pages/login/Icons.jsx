import { ReactComponent as Github } from '../../assets/img/github.svg';
import { ReactComponent as Google } from '../../assets/img/google.svg';
import { ReactComponent as Facebook } from '../../assets/img/facebook.svg';
import { ReactComponent as Logo } from '../../assets/img/stackoverflow-color.svg';
import { ReactComponent as LinkSvg } from '../../assets/img/linkIcon.svg';
import { ReactComponent as Error } from '../../assets/img/errorIcon.svg';

function GoogleIcon() {
  return <Google className="w-4 h-4 mr-1" />;
}
function FacebookIcon() {
  return <Facebook className="w-4 h-4 mr-1" />;
}
function GithubIcon() {
  return <Github className="w-4 h-4 mr-1" />;
}
function LogoIcon() {
  return <Logo className="mb-8" />;
}
function LinkIcon() {
  return <LinkSvg className="ml-1" />;
}
function ErrorIcon() {
  return <Error />;
}

export { GoogleIcon, FacebookIcon, GithubIcon, LogoIcon, LinkIcon, ErrorIcon };
export default {};
