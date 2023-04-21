import ReactQuill from 'react-quill';
import 'react-quill/dist/quill.snow.css';

function TextEdit() {
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
      <ReactQuill modules={modules} />
    </div>
  );
}

export default TextEdit;
