import ReactQuill from 'react-quill';
import 'react-quill/dist/quill.snow.css';

function TextEdit({ quillText, setQuillText }) {
  // 입력 값 받아오기
  const handleChange = (content, delta, source, editor) => {
    setQuillText(content);
  };
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
    <div>
      <ReactQuill modules={modules} value={quillText} onChange={handleChange} />
    </div>
  );
}

export default TextEdit;
