import { createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

const BASE_URL = 'http://ec2-3-39-212-111.ap-northeast-2.compute.amazonaws.com:8080';

export const fetchQuestion = createAsyncThunk('question/fetchQuestion', async id => {
  // const url = `${BASE_URL}/answers/${id}`;
  const url = `${BASE_URL}/answers/`;
  const response = await axios.get(url);
  return response.data;
});

export default {};
