import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';

export const loginAPI = createAsyncThunk('login', async ({ email, pw, BASE_URL }) => {
  const loginRes = await fetch(`${BASE_URL}/user`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      credentials: true,
    },
    body: JSON.stringify({ email, pw }),
  }).then(res => res.json());
  // .then(data => console.log(data));
  return loginRes;
});

const loginSlice = createSlice({
  name: 'loginSlice',
  initialState: { email: '', pw: '', token: '', state: '' },
  reducers: {
    setEmail: (state, action) => {
      state.email = action.payload.email;
    },
    setPW: (state, action) => {
      state.pw = action.payload.pw;
    },
  },
  extraReducers: builder => {
    builder.addCase(loginAPI.pending, (state, action) => {
      // 대기 상태일 때
    });
    builder.addCase(loginAPI.fulfilled, (state, action) => {
      state.token = action.payload;
      state.state = 'success';
    });
    builder.addCase(loginAPI.rejected, (state, action) => {
      // state.token = '';
      // state.state = 'fail';
    });
  },
});

export default loginSlice;
export const { setEmail, setPW } = loginSlice.actions;
