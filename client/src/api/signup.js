import { createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

const BASE_URL = process.env.REACT_APP_BASE_URL;
export const fetchSignUP = createAsyncThunk('signup', async ({ name, email, pw }) => {
  const url = `${BASE_URL}/v1/user/signup`;
  const response = await axios.post(url, { name, email, pw });
  return response.data;
});

export default {};
