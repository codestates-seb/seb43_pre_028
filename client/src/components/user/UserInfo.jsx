import { BirthIcon, CalendarIcon, ClockIcon, EditIcon, NetworkIcon } from '../Icons';
import ButtonCard from '../ui/ButtonCard';

function UserInfo() {
  return (
    <div className="flex items-center relative">
      <img
        src="https://cdn.pixabay.com/photo/2023/04/04/11/59/lake-biwa-7899206_1280.jpg"
        alt="유저 프로필 이미지"
        className="w-[128px] h-[128px] rounded-md mr-5"
      />
      <div>
        <p className="text-3xl mb-5">유저 이름</p>
        <ul className="fill-slate-500 text-slate-500 text-xs font-normal flex">
          <li className="flex mr-1">
            <BirthIcon className="mr-1" />
            <span>Member for 4 days</span>
          </li>
          <li className="flex mr-1">
            <ClockIcon className="mr-1" />
            <span>Last seen this week</span>
          </li>
          <li className="flex">
            <CalendarIcon className="mr-1" />
            <span>Visited 3 days, 2 consecutive</span>
          </li>
        </ul>
        <div className="absolute top-0 right-0 flex">
          <ButtonCard className="p-2 hover:bg-slate-50 border-slate-300 mx-2 text-slate-500">
            <EditIcon className="mr-1" />
            Edit Profile
          </ButtonCard>
          <ButtonCard className="p-2 hover:bg-slate-50 border-slate-300 mx-2 text-slate-500">
            <NetworkIcon className="mr-1" />
            Network Profile
          </ButtonCard>
        </div>
      </div>
    </div>
  );
}

export default UserInfo;
