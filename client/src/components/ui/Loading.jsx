import FadeLoader from 'react-spinners/FadeLoader';

function Loading() {
  return (
    <div className="flex w-full h-[90vh] justify-center items-center bg-red">
      <FadeLoader className="flex w-full bg-red" />
    </div>
  );
}

export default Loading;
