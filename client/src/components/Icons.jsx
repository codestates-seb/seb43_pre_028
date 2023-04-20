import { ReactComponent as Down } from '../assets/img/down.svg';
import { ReactComponent as Earth } from '../assets/img/earth.svg';
import { ReactComponent as Error } from '../assets/img/errorIcon.svg';
import { ReactComponent as Facebook } from '../assets/img/facebook.svg';
import { ReactComponent as Filter } from '../assets/img/filter-icon.svg';
import { ReactComponent as Github } from '../assets/img/github.svg';
import { ReactComponent as Google } from '../assets/img/google.svg';
import { ReactComponent as Hamburger } from '../assets/img/hamburger.svg';
import { ReactComponent as Info } from '../assets/img/info.svg';
import { ReactComponent as Pencil } from '../assets/img/pencil.svg';
import { ReactComponent as Question } from '../assets/img/question.svg';
import { ReactComponent as QuestionBg } from '../assets/img/question-create-bg.svg';
import { ReactComponent as Requtation } from '../assets/img/requtation.svg';
import { ReactComponent as Save } from '../assets/img/save.svg';
import { ReactComponent as Search } from '../assets/img/search.svg';
import { ReactComponent as SignUpLink } from '../assets/img/signup-link.svg';
import { ReactComponent as SpeechBubble } from '../assets/img/speech-bubble.svg';
import { ReactComponent as Star } from '../assets/img/star.svg';
import { ReactComponent as StackoverFlow } from '../assets/img/stackoverflow-color.svg';
import { ReactComponent as Vote } from '../assets/img/vote.svg';
import { ReactComponent as VoteDown } from '../assets/img/vote-down.svg';
import { ReactComponent as VoteUp } from '../assets/img/vote-up.svg';
import { ReactComponent as Birth } from '../assets/img/birthIcon.svg';
import { ReactComponent as Clock } from '../assets/img/clockIcon.svg';
import { ReactComponent as Calendar } from '../assets/img/calendarIcon.svg';
import { ReactComponent as Edit } from '../assets/img/editIcon.svg';
import { ReactComponent as Network } from '../assets/img/networkIcon.svg';

// * className 유효성 검사
const validateClassName = className => {
  return typeof className === 'string' && className.length > 0 ? { className } : '';
};

// * 👇 모두 icon에 해당되며 StackoverFlowLogo는 sprites 이미지에서 따옴.
export function DownIcon({ className }) {
  return <Down {...validateClassName(className)} />;
}

export function EarthIcon({ className }) {
  return <Earth {...validateClassName(className)} />;
}

export function ErrorIcon({ className }) {
  return <Error {...validateClassName(className)} />;
}

export function FacebookIcon({ className }) {
  return <Facebook {...validateClassName(className)} />;
}

export function FilterIcon({ className }) {
  return <Filter {...validateClassName(className)} />;
}

export function GithubIcon({ className }) {
  return <Github {...validateClassName(className)} />;
}

export function GoogleIcon({ className }) {
  return <Google {...validateClassName(className)} />;
}

export function HamburgerIcon() {
  return (
    <div className="flex justify-center items-center w-12 h-12">
      <Hamburger />
    </div>
  );
}

export function InfoIcon({ className }) {
  return <Info {...validateClassName(className)} />;
}

export function PencilIcon({ className }) {
  return <Pencil {...validateClassName(className)} />;
}

export function QuestionIcon({ className }) {
  return <Question {...validateClassName(className)} />;
}

export function QuestionBGImg({ className }) {
  return <QuestionBg {...validateClassName(className)} />;
}

export function RequtationIcon({ className }) {
  return <Requtation {...validateClassName(className)} />;
}

export function SignUpLinkIcon({ className }) {
  return <SignUpLink {...validateClassName(className)} />;
}

export function SaveIcon({ className }) {
  return <Save {...validateClassName(className)} />;
}

export function SearchIcon({ className }) {
  return <Search {...validateClassName(className)} />;
}

export function SpeechBubbleIcon({ className }) {
  return <SpeechBubble {...validateClassName(className)} />;
}

export function StarIcon({ className }) {
  return <Star {...validateClassName(className)} />;
}

export function StackoverFlowIcon({ className }) {
  return <StackoverFlow {...validateClassName(className)} />;
}

export function StackoverFlowLogo() {
  return (
    <div className="px-2 py-[6px] min-w-[164px] w-[166px] h-[47px] text-white">
      <div className="bg-sprites bg-logo w-full h-full bg-no-repeat" />;
    </div>
  );
}

export function VoteIcon({ className }) {
  return <Vote {...validateClassName(className)} />;
}

export function VoteDownIcon({ className }) {
  return <VoteDown {...validateClassName(className)} />;
}

export function VoteUpIcon({ className }) {
  return <VoteUp {...validateClassName(className)} />;
}

export function BirthIcon({ className }) {
  return <Birth {...validateClassName(className)} />;
}
export function ClockIcon({ className }) {
  return <Clock {...validateClassName(className)} />;
}
export function CalendarIcon({ className }) {
  return <Calendar {...validateClassName(className)} />;
}
export function EditIcon({ className }) {
  return <Edit {...validateClassName(className)} />;
}
export function NetworkIcon({ className }) {
  return <Network {...validateClassName(className)} />;
}

export default {};
