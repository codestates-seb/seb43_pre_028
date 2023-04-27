import Voting from '../asset/Voting';
import EditDelete from '../asset/EditDelete';
import User from '../asset/User';

// 질문이 생성된 날짜, 수정된 날짜, 조회수를 렌더링하는 컴포넌트
function Days({ data }) {
  const today = new Date(); // 오늘 날짜
  const created = new Date(data.createAt); // 질문 생성 날짜
  const modified = new Date(data.modifiedAt); // 질문 수정 날짜

  // 각 날짜의 차이를 일 수로 계산
  const daysSinceCreated = Math.floor((today - created) / (1000 * 60 * 60 * 24));
  const daysSinceModified = Math.floor((today - modified) / (1000 * 60 * 60 * 24));

  return (
    <div className="text-sm pb-4 border-b-2 border-[#E3E6E8] border-solid">
      <span className="font-light">Asked </span>
      {daysSinceCreated} days ago
      <span className="font-light"> &nbsp;&nbsp;&nbsp;Modified </span>
      {daysSinceModified} days ago
      <span className="font-light"> &nbsp;&nbsp;&nbsp;Viewed </span>
      {data.views} times
    </div>
  );
}

function Question({ data }) {
  return (
    <article className="pb-4 border-b-2 border-[#E3E6E8] border-solid">
      <div className="flex w-full justify-between">
        <div className="text-2xl">{data.title}</div>
        <button
          type="button"
          className="flex text-sm font-light bg-[#1e95ff] hover:bg-[#0074CC] text-white rounded-[4px] p-2"
        >
          Ask Question
        </button>
      </div>
      <Days data={data} />
      <div className="flex mt-4 w-full">
        <div className="mr-4 flex-shrink-0">
          <Voting data={data} />
        </div>
        <div className="break-all">
          {`${data.content.problem}\n${data.content.tried}`}
          <div className="flex mt-10 justify-between">
            <EditDelete className="mr-2" />
            <User data={data} />
          </div>
        </div>
      </div>
    </article>
  );
}

export default Question;
