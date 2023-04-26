import { createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

const BASE_URL = process.env.REACT_APP_BASE_URL;
export const fetchLogin = createAsyncThunk('token', async () => {
  const url = `${BASE_URL}/v1/token`;
  const token = sessionStorage.getItem('token');
  const response = await axios.get(url, {
    headers: {
      'Content-Type': 'application/json',
      withCredentials: true,
      Authorization: `Bearer ${token}`,
    },
  });
  return response;
});

export default {};
