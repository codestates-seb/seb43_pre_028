import { createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

// const BASE_URL = process.env.REACT_APP_BASE_URL;

export const fetchQuestion = createAsyncThunk('question/fetchQuestion', async id => {
  const url = `https://6eba420e-68d0-40ee-8655-1b6266b1c756.mock.pstmn.io/questions/${id}`;
  const response = await axios.get(url);
  return response.data;
});

export default {};
