import { createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

const BASE_URL = process.env.REACT_APP_BASE_URL;
// * : 토큰을 사용해서 유저 정보를 받아오는 api
export const fetchUser = createAsyncThunk('users', async () => {
  const url = `${BASE_URL}/user`;
  const token = sessionStorage.getItem('token');
  const response = await axios.get(url, {
    headers: {
      'Content-Type': 'application/json',
      withCredentials: true,
      Authorization: `Bearer ${token}`,
    },
  });
  return response.data;
});

export default {};
