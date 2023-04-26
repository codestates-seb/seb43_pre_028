import { createSlice } from '@reduxjs/toolkit';
import { validToken } from '../api/validToken';

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
    builder.addCase(validToken.fulfilled, (state, action) => {
      state.status = true;
    });
    builder.addCase(validToken.rejected, (state, action) => {
      state.status = false;
    });
  },
});

export default loginSlice;
export const { setStatus } = loginSlice.actions;
