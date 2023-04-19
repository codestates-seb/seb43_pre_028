import { ReactComponent as Question } from '../../assets/img/questionIcon.svg';
import { ReactComponent as Vote } from '../../assets/img/voteIcon.svg';
import { ReactComponent as Save } from '../../assets/img/saveIcon.svg';
import { ReactComponent as Requtation } from '../../assets/img/requtationIcon.svg';
import { ReactComponent as LinkSvg } from '../../assets/img/linkIcon.svg';

function QuestionIcon() {
  return <Question className="fill-[#1e95ff]" />;
}
function VoteIcon() {
  return <Vote className="fill-[#1e95ff]" />;
}
function SaveIcon() {
  return <Save className="fill-[#1e95ff]" />;
}
function RequtationIcon() {
  return <Requtation className="fill-[#1e95ff]" />;
}
function LinkIcon() {
  return <LinkSvg className="ml-1" />;
}

export { QuestionIcon, VoteIcon, SaveIcon, RequtationIcon, LinkIcon };
export default {};
