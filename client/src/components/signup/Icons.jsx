import { ReactComponent as Question } from '../../assets/img/questionIcon.svg';
import { ReactComponent as Vote } from '../../assets/img/voteIcon.svg';
import { ReactComponent as Save } from '../../assets/img/saveIcon.svg';
import { ReactComponent as Requtation } from '../../assets/img/requtationIcon.svg';
import { ReactComponent as LinkSvg } from '../../assets/img/linkIcon.svg';

function QuestionIcon() {
  return <Question className="fill-blue-500" />;
}
function VoteIcon() {
  return <Vote className="fill-blue-500" />;
}
function SaveIcon() {
  return <Save className="fill-blue-500" />;
}
function RequtationIcon() {
  return <Requtation className="fill-blue-500" />;
}
function LinkIcon() {
  return <LinkSvg className="ml-1" />;
}

export { QuestionIcon, VoteIcon, SaveIcon, RequtationIcon, LinkIcon };
export default {};
