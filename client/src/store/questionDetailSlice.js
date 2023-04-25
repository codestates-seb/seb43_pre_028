// questionDetailSlice.js
import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

export const fetchQuestion = createAsyncThunk('question/fetchQuestion', async id => {
  const url = `https://6eba420e-68d0-40ee-8655-1b6266b1c756.mock.pstmn.io/questions/${id}`;
  const response = await axios.get(url);
  return response.data;
});

const questionDetailSlice = createSlice({
  name: 'questionDetail',
  initialState: {
    title: '',
    createdAt: '',
    modifiedAt: '',
    views: '',
    content: '',
    answer: [],
  },
  reducers: {
    setQuestion: (state, action) => {
      return action.payload;
    },
  },
  extraReducers: builder => {
    builder.addCase(fetchQuestion.fulfilled, (state, action) => {
      return action.payload;
    });
  },
});

export const { setQuestion } = questionDetailSlice.actions;

export const selectQuestion = state => state.questionDetail;

export default questionDetailSlice;
