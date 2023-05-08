import { createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

const BASE_URL = process.env.REACT_APP_BASE_URL;
export const fetchLogin = createAsyncThunk('login', async ({ email, pw }) => {
  const url = `${BASE_URL}/v1/user/login`;
  const response = await axios.post(url, { email, pw });
  return response.data;
});

export default {};
