import { VoteUpIcon, VoteDownIcon } from '../../Icons';

// 질문과 답변에 대한 추천/비추천을 렌더링하는 컴포넌트
function Voting({ data }) {
  return (
    <div className="flex flex-col mt-2 items-center">
      <VoteUpIcon />
      {data.votes}
      <VoteDownIcon />
    </div>
  );
}

export default Voting;
