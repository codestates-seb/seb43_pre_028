// questionDetailSlice.js
import { createSlice } from '@reduxjs/toolkit';
import { fetchQuestion } from '../api/questionDetail';

const initialState = {
  status: 'loading',
  question: {},
};

const questionDetailSlice = createSlice({
  name: 'questionDetail',
  initialState,
  reducers: {
    setQuestion: (state, action) => {
      return action.payload;
    },
  },
  extraReducers: builder => {
    // builder.addCase(fetchQuestion.fulfilled, (state, action) => {
    //   return action.payload;
    // });
    builder.addCase(fetchQuestion.pending, (state, action) => {
      state.status = 'loading';
    });
    builder.addCase(fetchQuestion.fulfilled, (state, action) => {
      state.status = 'succeed';
      state.question = action.payload;
    });
    builder.addCase(fetchQuestion.rejected, (state, action) => {
      state.status = 'failed';
    });
  },
});

export const { setQuestion } = questionDetailSlice.actions;

export const selectQuestion = state => state.questionDetail;

export default questionDetailSlice;
