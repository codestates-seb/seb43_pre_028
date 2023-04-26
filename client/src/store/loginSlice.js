import { createSlice } from '@reduxjs/toolkit';
import { fetchLogin } from '../api/login';

// * : email, pw 등의 정보는 여기 저장하지 않고 로그인 유무만 다루는 것에 대해서.
const loginSlice = createSlice({
  name: 'loginSlice',
  initialState: { status: false },
  reducers: {
    setStatus: (state, action) => {
      state.status = action.payload;
    },
  },
  extraReducers: builder => {
    builder.addCase(fetchLogin.pending, (state, action) => {
      // 대기 상태일 때
    });
    builder.addCase(fetchLogin.fulfilled, (state, action) => {
      sessionStorage.setItem('token', state.token);
      state.status = true;
    });
    builder.addCase(fetchLogin.rejected, (state, action) => {
      state.status = false;
    });
  },
});

// 201 'create'

export default loginSlice;
export const { setStatus } = loginSlice.actions;
