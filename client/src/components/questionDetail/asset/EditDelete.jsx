// 질문이나 답변의 수정/삭제 버튼을 렌더링하는 컴포넌트
function EditDelete() {
  return (
    <div>
      <button className="font-light" type="button">
        Edit
      </button>
      <button className="font-light ml-2" type="button">
        Delete
      </button>
    </div>
  );
}

export default EditDelete;
