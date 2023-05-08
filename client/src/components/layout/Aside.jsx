import { StackoverFlowIcon, PencilIcon, SpeechBubbleIcon } from '../Icons';

function Aside() {
  return (
    <div className="w-[400px] h-[370px] ml-6 rounded-[4px] bg-[#fdf7e2] text-[12px] border-[#f1e5bc] border-solid border-[1px]">
      <div>
        <h5 className="p-3 text-[13px] bg-[#fbf3d5] font-semibold border-solid border-[#f1e5bc] border-b-[1px]">
          The OverFlow Blog
        </h5>
        <li className="flex w-full gap-1 px-4 py-2 ">
          <div>
            <PencilIcon />
          </div>
          Community is the future of AI
        </li>
        <li className="flex gap-1 px-4 py-2 ">
          <div>
            <PencilIcon />
          </div>
          We bought a university: how one coding school doubled down on brick and...
        </li>
      </div>
      <div>
        <h5 className="p-3 text-[13px] bg-[#fbf3d5] font-semibold border-solid border border-[#f1e5bc] border-y-[1px]">
          Featured on Meta
        </h5>
        <li className="flex gap-1 px-4 py-2 ">
          <div>
            <SpeechBubbleIcon />
          </div>
          Improving the copy in the close modal and post notices - 2023 edition
        </li>
        <li className="flex gap-1 px-4 py-2 ">
          <div>
            <SpeechBubbleIcon />
          </div>
          New blog post from our CEO Prashanth: Community is the future of AI
        </li>
        <li className="flex gap-1 px-4 py-2 ">
          <div>
            <StackoverFlowIcon className="w-4 h-4 fill-black" />
          </div>
          Temporary policy: ChatGPT is banned
        </li>
        <li className="flex gap-1 px-4 py-2 ">
          <div>
            <StackoverFlowIcon className="w-4 h-4 fill-black" />
          </div>
          The [protection] tag is being burninated
        </li>
        <li className="flex gap-1 px-4 py-2 ">
          <div>
            <StackoverFlowIcon className="w-4 h-4 fill-black" />
          </div>
          Content Discovery initiative 4/13 update: Related questions using a Machine...
        </li>
      </div>
    </div>
  );
}

export default Aside;
