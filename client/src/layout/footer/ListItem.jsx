const getWidthRatio = type => {
  const ratio = {
    big: 7,
    medium: 6,
    small: 5,
  };

  let widthRatio = null;
  if (type === 'network') widthRatio = 7;
  else if (type === 'stackoverflow') widthRatio = 6;
  else widthRatio = 5;

  return `calc(100% * ${widthRatio} / ${ratio.big + ratio.medium * 2 + ratio.small})`;
};

function ListItem({ type, headerName, listNames }) {
  return (
    <div
      style={{ width: getWidthRatio(type) }}
      className="flex flex-col items-start text-[13px] pr-3"
    >
      <h5 className="font-bold text-[#BABFC4]">{headerName}</h5>
      <ul className="flex flex-col items-start mt-3 gap-1">
        {listNames.map((listName, index) => (
          <li key={`${index + listName}`}>{listName}</li>
        ))}
      </ul>
    </div>
  );
}

export default ListItem;
