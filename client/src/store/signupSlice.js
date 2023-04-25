import { createSlice } from '@reduxjs/toolkit';
import { fetchSignUP } from '../api/signup';

const signupSlice = createSlice({
  name: 'signupSlice',
  initialState: { state: false },
  extraReducers: builder => {
    // builder.addCase(fetchSignUP.pending, (state, action) => {
    //   // 대기 상태일 때
    // });
    builder.addCase(fetchSignUP.fulfilled, (state, action) => {
      state.state = true;
    });
    builder.addCase(fetchSignUP.rejected, (state, action) => {
      // state.token = '';
      state.state = false;
    });
  },
});

export default signupSlice;
// export const { setName, setEmail, setPW } = signupSlice.actions;
