// * 버튼 공통 레이아웃.
// * 기본 적용 사항 : 테두리(1px,solid,radius), 플렉스(center정렬), 폰트(무게, 사이즈)
// * 특이사항 : 버튼의 타입이 'button'일 경우 기입 필요 없음. submit일 경우 기입.

function ButtonCard({ children, className, type, onClickHandler }) {
  return (
    <button
      type={type ? 'submit' : 'button'}
      className={`border border-solid rounded flex justify-center items-center font-normal text-xs ${className}`}
      onClick={onClickHandler}
    >
      {children}
    </button>
  );
}

export default ButtonCard;
