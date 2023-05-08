// 질문이나 답변 작성자 정보를 렌더링하는 컴포넌트

function formatDate(dateString) {
  const date = new Date(dateString);
  const months = [
    'Jan',
    'Feb',
    'Mar',
    'Apr',
    'May',
    'Jun',
    'Jul',
    'Aug',
    'Sep',
    'Oct',
    'Nov',
    'Dec',
  ];
  const month = months[date.getMonth()];
  const day = date.getDate();
  const hour = date.getHours();
  const minute = date.getMinutes();
  const formattedDate = `${month} ${day} at ${hour}:${minute}`;
  return formattedDate;
}

function User({ data }) {
  return (
    <div className="flex flex-col w-[200px] bg-[#D9EAF7] p-1">
      <div className="text-[12px] text-[#6a737c]">
        asked <span title="2023-03-27 17:23:11Z">{formatDate(data.createdAt)}</span>
      </div>
      <div className="flex items-center mt-1">
        <div>
          <a href="/users/2772805/pbrockmann">
            <div>
              <img src={data.userImage} alt="userImage" width="32" height="32" />
            </div>
          </a>
        </div>
        <div className="flex flex-col">
          <span className="text-[#0074cc] text-[13px] ml-2">{data.userName}</span>
          <div className="text-xs ml-2">
            <span className="font-bold">333 </span>
            <span title="5 silver badges" aria-hidden="true">
              <div className="inline-block w-[5px] h-[5px] rounded-full bg-[#B4B8BC]">
                {' '}
              </div>
              <span> 5 </span>
            </span>
            <span title="16 bronze badges" aria-hidden="true">
              <div className="inline-block w-[5px] h-[5px] rounded-full bg-[#D1A684]">
                {' '}
              </div>
              <span>16</span>
            </span>
          </div>
        </div>
      </div>
    </div>
  );
}

export default User;
