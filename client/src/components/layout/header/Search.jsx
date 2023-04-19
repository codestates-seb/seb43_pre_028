import { SearchIcon } from '../../Icons';

function Search() {
  return (
    <div className="flex items-center w-full max-w-[720px] ml-2 p-2 bg-white rounded-[4px] border-solid border-[1px] border-nav-color/30 ">
      <SearchIcon />
      <input type="text" placeholder="Search..." className="ml-2 outline-none" />
    </div>
  );
}

export default Search;
