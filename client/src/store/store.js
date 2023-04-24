import { configureStore } from '@reduxjs/toolkit';
import loginSlice from './loginSlice';

// ! : reducer 안에 생성한 slice를 아래와 같은 방식으로 추가.
const store = configureStore({
  reducer: {
    login: loginSlice.reducer,
  },
});
export default store;
