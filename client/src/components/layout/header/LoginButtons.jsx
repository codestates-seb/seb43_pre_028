function LoginButtons() {
  return (
    <div className="flex h-[36px] gap-1">
      <button
        type="button"
        className="ml-1 bg-[#e1ecf4] hover:bg-[#B3D3EA] text-[#39739d] border-[1px] border-[#b2cbdd] rounded-[4px] p-2"
      >
        Login
      </button>
      <button
        type="button"
        className="flex bg-[#1e95ff] hover:bg-[#0074CC] text-white rounded-[4px] p-2"
      >
        Sign up
      </button>
    </div>
  );
}

export default LoginButtons;
