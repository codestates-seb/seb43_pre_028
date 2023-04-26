function Pagination({ questions }) {
  return (
    <div className="flex justify-center items-center gap-2 mt-10">
      <button
        type="button"
        className="w-[26px] h-[26px] rounded-sm border-[1px] boder-solid border-[#525960]/20 text-[13px] bg-[#f48225] text-white"
      >
        1
      </button>
      <button
        type="button"
        className="w-[26px] h-[26px] rounded-sm border-[1px] boder-solid border-[#525960]/20 text-[13px] "
      >
        2
      </button>
      <button
        type="button"
        className="w-[26px] h-[26px] rounded-sm border-[1px] boder-solid border-[#525960]/20 text-[13px] "
      >
        3
      </button>
      <button
        type="button"
        className="w-[26px] h-[26px] rounded-sm border-[1px] boder-solid border-[#525960]/20 text-[13px] "
      >
        4
      </button>
      <button
        type="button"
        className="w-[26px] h-[26px] rounded-sm border-[1px] boder-solid border-[#525960]/20 text-[13px] "
      >
        5
      </button>
    </div>
  );
}

export default Pagination;
