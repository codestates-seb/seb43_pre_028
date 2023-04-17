import Nav from './Nav';
import Teams from './Teams';

function Aside() {
  return (
    <aside className="fixed flex flex-col w-[164px] text-[13px] pt-6 text-nav-color font-normal border-solid border-r-[1px] border-slate-300 overflow-y-auto">
      <div type="button" className="flex justify-start pl-2 py-1 pr-1 font-medium">
        Home
      </div>
      <Nav />
      <Teams />
    </aside>
  );
}

export default Aside;
