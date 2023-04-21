import UserLabel from '../ui/UserLabel';

function PrivateInfoEdit() {
  return (
    <>
      <div className="mt-5 text-xl flex items-center">
        Private information{' '}
        <span className="text-xs ml-3 text-slate-500">Not shown publicly</span>
      </div>
      <div className="flex flex-col border border-solid border-slate-300 bg-white rounded my-4 p-5 justify-between">
        <UserLabel className="md:w-[390px] mt-1">Full name</UserLabel>
      </div>
    </>
  );
}

export default PrivateInfoEdit;
