import { ReactComponent as Earth } from '../../../assets/img/earth.svg';
import { ReactComponent as Info } from '../../../assets/img/info.svg';
import { ReactComponent as Star } from '../../../assets/img/star.svg';

function EarthIcon() {
  return <Earth />;
}
function InfoIcon() {
  return <Info className="fill-slate-400 hover:fill-slate-800" />;
}
function StarIcon() {
  return <Star className="fill-[#F48225]" />;
}

export { EarthIcon, InfoIcon, StarIcon };
export default {};
