import { createSlice } from '@reduxjs/toolkit';
import { fetchSignUP } from '../api/signup';

const signupSlice = createSlice({
  name: 'signupSlice',
  initialState: { name: '', email: '', pw: '', state: false },
  reducers: {
    setName: (state, action) => {
      state.name = action.payload.email;
    },
    setEmail: (state, action) => {
      state.email = action.payload.email;
    },
    setPW: (state, action) => {
      state.pw = action.payload.pw;
    },
  },
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
export const { setName, setEmail, setPW } = signupSlice.actions;
