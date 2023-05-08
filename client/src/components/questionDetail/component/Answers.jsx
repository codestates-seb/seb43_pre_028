import Voting from '../asset/Voting';
import User from '../asset/User';
import EditDelete from '../asset/EditDelete';

function Answers({ data }) {
  return (
    <article>
      <div className="text-xl mt-10">{data.length} Answers</div>
      <div className="flex flex-col mt-4">
        {data.map(answer => (
          <div
            key={Math.random().toString(36).substring(2, 9)}
            className="flex pb-5 mt-5 mb-10 border-b-2 border-[#E3E6E8] border-solid"
          >
            <div className="mr-4 flex-shrink-0 ">
              <Voting data={answer} />
            </div>
            <div className="break-all w-full">
              {answer.content}
              <div className="flex mt-10  w-full justify-between">
                <EditDelete className="mr-2" />
                <User data={answer} />
              </div>
            </div>
          </div>
        ))}
      </div>
    </article>
  );
}

export default Answers;
