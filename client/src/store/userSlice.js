import { createSlice } from '@reduxjs/toolkit';
import { fetchUser } from '../api/user';

// * : 유저 정보를 담는 state
// * : password 정보 저장 유무 이야기해보기
const initialState = {
  id: 0,
  userName: '',
  userImg: '',
};

const userSlice = createSlice({
  name: 'user',
  initialState,
  reducers: {},
  extraReducers: builder => {
    // builder.addCase(fetchUser.pending, (state, action) => {
    // });
    builder.addCase(fetchUser.fulfilled, (state, action) => {
      state.id = action.payload.id;
      state.userName = action.payload.userName;
      state.userImg = action.payload.userImg;
    });
    // builder.addCase(fetchUser.rejected, (state, action) => {
    // });
  },
});

export default userSlice;
