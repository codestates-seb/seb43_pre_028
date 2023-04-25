// import { QuestionIcon, RequtationIcon, SaveIcon, VoteIcon } from './Icons';

import { QuestionIcon, RequtationIcon, SaveIcon, VoteIcon } from '../Icons';

function LeftContents() {
  return (
    <div className="hidden mr-10 md:block">
      <h1 className="text-2xl">Join the Stack Overflow community</h1>
      <div className="font-light">
        <p className="flex text-[0.9rem] my-4 items-center">
          <QuestionIcon className="fill-[#1e95ff]" />
          <span className="ml-2">Get unstuck — ask a question</span>
        </p>
        <p className="flex text-[0.9rem] my-4 items-center">
          <VoteIcon className="fill-[#1e95ff]" />
          <span className="ml-2">Unlock new privileges like voting and commenting</span>
        </p>
        <p className="flex text-[0.9rem] my-4 items-center">
          <SaveIcon className="fill-[#1e95ff]" />
          <span className="ml-2">
            Save your favorite questions, answers, watch tags, and
            <br />
            more
          </span>
        </p>
        <p className="flex text-[0.9rem] my-4 items-center">
          <RequtationIcon className="fill-[#1e95ff]" />
          <span className="ml-2">Earn reputation and badges</span>
        </p>
        <div className="text-xs">
          <p>Collaborate and share knowledge with a private group for FREE.</p>
          <p>
            <a href="http://#" className="text-sky-800 hover:text-sky-600">
              Get Stack Overflow for Teams free for up to 50 users
            </a>
            .
          </p>
        </div>
      </div>
    </div>
  );
}

export default LeftContents;
