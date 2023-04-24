import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { VoteUpIcon, VoteDownIcon } from '../Icons';
import Texteditor from './TextEditor';

// 질문이 생성된 날짜, 수정된 날짜, 조회수를 렌더링하는 컴포넌트
function Days({ data }) {
  const today = new Date(); // 오늘 날짜
  const created = new Date(data.createdAt); // 질문 생성 날짜
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

// 질문이나 답변의 수정 버튼을 렌더링하는 컴포넌트
function Edit() {
  return (
    <button className="font-light" type="button">
      Edit
    </button>
  );
}

// 질문이나 답변 작성자 정보를 렌더링하는 컴포넌트
function User({ data }) {
  return (
    <div className="flex flex-col w-[200px] bg-[#D9EAF7] p-1">
      <div className="text-[12px] text-[#6a737c]">
        asked <span title="2023-03-27 17:23:11Z">Mar 27 at 17:23</span>
      </div>
      <div className="flex items-center mt-1">
        <div>
          <a href="/users/2772805/pbrockmann">
            <div>
              <img
                src="https://i.stack.imgur.com/7N6Ln.jpg?s=64&amp;g=1"
                alt="PBrockmann's user avatar"
                width="32"
                height="32"
              />
            </div>
          </a>
        </div>
        <div className="flex flex-col">
          <span className="text-[#0074cc] text-[13px] ml-2">PBrockmann</span>
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
export default function QuestionDetail() {
  const url = 'https://6eba420e-68d0-40ee-8655-1b6266b1c756.mock.pstmn.io/questions';

  const [dummy, setDummy] = useState({
    title: '',
    createdAt: '',
    modifiedAt: '',
    views: '',
    content: '',
    answer: [],
  });

  useEffect(() => {
    axios
      .get(`${url}/123`)
      .then(response => {
        setDummy(response.data);
      })
      .catch(error => {
        console.error(error);
      });
  }, []);
  // 질문과 답변의 상세 페이지를 렌더링하는 컴포넌트
  return (
    <section className="flex w-full flex-col pl-6">
      <div className="flex w-full justify-between">
        <div className="text-2xl">{dummy.title}</div>
        <button
          type="button"
          className="flex text-sm font-light bg-[#1e95ff] hover:bg-[#0074CC] text-white rounded-[4px] p-2"
        >
          Ask Question
        </button>
      </div>
      <Days data={dummy} />
      <div className="flex mt-4 w-full">
        <div className="mr-4 flex-shrink-0">
          <Voting data={dummy} />
        </div>
        <div className="break-all">
          {dummy.content}
          <div className="flex mt-10 justify-between">
            <Edit className="mr-2" />
            <User data={dummy} />
          </div>
        </div>
      </div>
      <div className="text-xl mt-10">{dummy.answer.length} Answers</div>
      <div className="flex flex-col mt-4">
        {dummy.answer.map(answer => (
          <div
            key={Math.random().toString(36).substring(2, 9)}
            className="flex pb-5 mt-5 mb-10 border-b-2 border-[#E3E6E8] border-solid"
          >
            <div className="mr-4 flex-shrink-0 ">
              <Voting data={answer} />
            </div>
            <div className="break-all">
              {answer.content}
              <div className="flex mt-10 justify-between">
                <Edit className="mr-2" />
                <User data={answer} />
              </div>
            </div>
          </div>
        ))}
      </div>
      <div className="mb-4">Your Answer</div>
      {/* <div className="w-[650px] h-[300px] bg-[#a5a5a5]">l</div> */}
      <Texteditor />
      <div className="flex justify-between">
        <button
          type="button"
          className="flex grow-0 mt-4 text-sm font-light bg-[#1e95ff] hover:bg-[#0074CC] text-white rounded-[4px] p-2"
        >
          Post Your Anwser
        </button>
      </div>
    </section>
  );
}
