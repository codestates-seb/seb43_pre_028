function ContentItem() {
  return (
    <div className="flex p-4 text-[13px] text-nav-color border-t-[1px] border-nav-color/20 border-solid">
      <div className="flex flex-col gap-2 w-[108px] mr-4">
        <div className="flex justify-end text-black font-medium">
          <span>0 votes</span>
        </div>
        <div className="flex justify-end">
          <span className="text-[#306f44] border-[#306f44] border-[1px] border-solid rounded-sm py-[2px] px-1">
            0 answers
          </span>
        </div>
        <div className="flex justify-end">
          <span>8 views</span>
        </div>
      </div>
      <div className="w-full">
        <h3 className="text-[17px] text-[#0374cc] mb-1">
          How to adjust sp.signal.spectrogram so that the x-axis starts at 0?
        </h3>
        <p className="h-[34px] mb-2 overflow-auto">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus ducimus minus
          accusantium, facere cumque distinctio saepe optio dolorem molestias quod
          delectus quae quia harum maiores cum. Soluta quidem quibusdam veniam. Lorem
          ipsum dolor sit amet consectetur adipisicing elit. Natus ducimus minus
          accusantium, facere cumque distinctio saepe optio dolorem molestias quod
          delectus quae quia harum maiores cum. Soluta quidem quibusdam veniam.
        </p>
        <div className="flex justify-end gap-1">
          <img
            src="https://www.gravatar.com/avatar/f3573471102862b30a504dc9fbbeb617?s=32&d=identicon&r=PG&f=1"
            alt="avartar"
            className="w-4 h-4"
          />{' '}
          <span className="text-[#3283d1]">Alexrs95s</span>
          <span>
            <b className="font-semibold">382</b> asked
          </span>
          <span>13 mins ago</span>
        </div>
      </div>
    </div>
  );
}

export default ContentItem;
