import { createSlice } from '@reduxjs/toolkit';
import { fetchLogin } from '../api/login';

const loginSlice = createSlice({
  name: 'loginSlice',
  initialState: { email: '', pw: '', token: '', state: false },
  reducers: {
    setEmail: (state, action) => {
      state.email = action.payload;
    },
    setPW: (state, action) => {
      state.pw = action.payload;
    },
    setToken: (state, action) => {
      state.token = action.payload;
    },
  },
  extraReducers: builder => {
    // builder.addCase(loginAPI.pending, (state, action) => {
    //   // 대기 상태일 때
    // });
    builder.addCase(fetchLogin.fulfilled, (state, action) => {
      // state.token = action.payload;
      // sessionStorage.setItem('token', state.token);
      // sessionStorage.getItem('token')
      // 여기서? token을? 다루나?
      state.state = true;
    });
    builder.addCase(fetchLogin.rejected, (state, action) => {
      // state.token = '';
      state.state = false;
    });
  },
});

// 201 'create'

export default loginSlice;
export const { setEmail, setPW, setToken } = loginSlice.actions;
