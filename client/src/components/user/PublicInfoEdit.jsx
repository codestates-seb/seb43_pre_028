import ReactQuill from 'react-quill';
import 'react-quill/dist/quill.snow.css';
import UserLabel from '../ui/UserLabel';

// ? : 'Change picture' : 현재 img 파일 업로드로 연결
// ? : 원래 사이트는 'Change picture'을 누르면 옵션창이 뜨는 방식.  추후 의견 받아 수정 혹은 보류 예정.

function PublicInfoEdit() {
  const modules = {
    toolbar: {
      container: [
        [{ header: [1, 2, false] }],
        ['underline', 'strike', 'blockquote'],
        [{ list: 'ordered' }, { list: 'bullet' }, 'link'],
        ['image', 'code-block'],
        ['clean'],
      ],
    },
  };
  return (
    <>
      <div className="mt-5 text-xl">Public information</div>
      <div className="flex flex-col border border-solid border-slate-300 bg-white rounded my-4 p-5 justify-between">
        <label
          htmlFor="img"
          className="font-semibold relative w-[164px] h-[190px] overflow-hidden rounded-md"
        >
          Profile image{}
          <div className="w-[164px] h-[164px] rounded-md mt-2 overflow-hidden relative">
            <img
              src="https://cdn.pixabay.com/photo/2023/04/04/11/59/lake-biwa-7899206_1280.jpg"
              alt="유저 프로필 이미지"
              className="w-[164px] h-[164px]"
            />
            <input className="hidden" id="img" type="file" accept="image/*" />
          </div>
          <label
            htmlFor="img"
            className="text-xs text-white absolute bottom-0 right-0 w-[164px] h-[35px] bg-slate-700 flex items-center justify-center hover:bg-slate-800"
          >
            Change picture
          </label>
        </label>
        <UserLabel className="md:w-[390px] mt-1">Display name</UserLabel>
        <UserLabel className="md:w-[390px] mt-1">Location</UserLabel>
        <UserLabel className="md:w-[390px] mt-1">Title</UserLabel>
        <label htmlFor="aboutMe" className="font-semibold my-1 h-[300px]">
          About Me
          <ReactQuill className="h-[235px]" id="aboutMe" modules={modules} />
        </label>
      </div>
    </>
  );
}

export default PublicInfoEdit;
