import { createSlice } from '@reduxjs/toolkit';

import { fetchAllQuestions } from '../api/question';

const initialState = {
  status: 'loading',
  questions: [],
};

const questionSlice = createSlice({
  name: 'question',
  initialState,
  reducers: {},
  extraReducers: builder => {
    builder.addCase(fetchAllQuestions.pending, (state, action) => {
      state.status = 'loading';
    });
    builder.addCase(fetchAllQuestions.fulfilled, (state, action) => {
      state.questions = action.payload;
      state.status = 'succeed';
    });
    builder.addCase(fetchAllQuestions.rejected, (state, action) => {
      state.status = 'failed';
    });
  },
});

export { fetchAllQuestions };
export default questionSlice;
