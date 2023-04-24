import { Link } from 'react-router-dom';

function ContentItem({
  questionId,
  title,
  content,
  views,
  votes,
  answers,
  userName,
  userImage,
  askedCount,
  createAt,
  modifiedAt,
}) {
  return (
    <div className="flex p-4 text-[13px] text-nav-color border-t-[1px] border-nav-color/20 border-solid">
      <div className="flex flex-col gap-2 w-[108px] mr-4">
        <div className="flex justify-end text-black font-medium">
          <span>{votes} votes</span>
        </div>
        <div className="flex justify-end">
          <span className="text-[#306f44] border-[#306f44] border-[1px] border-solid rounded-sm py-[2px] px-1">
            {answers} answers
          </span>
        </div>
        <div className="flex justify-end">
          <span>{views} views</span>
        </div>
      </div>
      <div className="w-full">
        <Link to={`/questions/${questionId}`}>
          <h3 className="text-[17px] text-[#0374cc] mb-1">{title}</h3>
        </Link>
        <p className="h-[34px] mb-2 overflow-auto">
          {`${content.problem}\n${content.tried}`}
        </p>
        <div className="flex justify-end gap-1">
          <img src={userImage} alt="avartar" className="w-4 h-4" />{' '}
          <span className="text-[#3283d1]">{userName}</span>
          <span>
            <b className="font-semibold">{askedCount}</b> asked
          </span>
          <span>13 mins ago</span>
        </div>
      </div>
    </div>
  );
}

export default ContentItem;
