import React from 'react';
import dummy from '../data/dummy';
import { ReactComponent as VoteUp } from '../assets/img/voteUp.svg';
import { ReactComponent as VoteDown } from '../assets/img/voteDown.svg';

function Title() {
  return <div className="text-2xl">{dummy[0].title}</div>;
}

function Date() {
  return (
    <div>
      <span className="font-light">Asked </span>
      {dummy[0].createdAt.substring(0, 10)}
      <span className="font-light"> Modified </span>
      {dummy[0].modifiedAt.substring(0, 10)}
      <span className="font-light"> Viewed </span>
      {dummy[0].views}
    </div>
  );
}

function Voting() {
  return <p>{dummy[0].votes} votes</p>;
}

function Content() {
  return <p>{dummy[0].content}</p>;
}

function Edit() {
  return <button type="button">Edit</button>;
}

function User() {
  return <p>{dummy[0].name}</p>;
}

export default function QuestionDetail() {
  return (
    <section className="bg-white rounded-lg shadow-lg p-4">
      <Title />
      <Date />
      <div className="flex mt-4">
        <div className="mr-4 flex-shrink-0">
          <VoteUp />
          <Voting />
          <VoteDown />
        </div>
        <div>
          <Content />
          <div className="flex mt-2 justify-between">
            <Edit className="mr-2" />
            <User />
          </div>
        </div>
      </div>
      <div className="flex mt-4">
        <div className="mr-4 flex-shrink-0">
          <VoteUp />
          <Voting />
          <VoteDown />
        </div>
        <Content />
      </div>
    </section>
  );
}
