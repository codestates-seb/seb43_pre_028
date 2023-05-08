function Pagination({ selectedIndex, onPaginationButtonClickHandler, buttons }) {
  return (
    <div className="flex justify-center items-center gap-2 mt-10">
      {buttons.map(button => (
        <button
          type="button"
          key={button}
          onClick={e => onPaginationButtonClickHandler(e, button)}
          className={`w-[26px] h-[26px] rounded-sm border-[1px] boder-solid border-[#525960]/20 text-[13px] ${
            selectedIndex === button && 'bg-[#f48225] text-white'
          }`}
        >
          {button + 1}
        </button>
      ))}
    </div>
  );
}

export default Pagination;
