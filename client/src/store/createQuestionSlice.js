import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  title: '',
  problem: '',
  tried: '',
};

const createQuestionSlice = createSlice({
  name: 'question',
  initialState,
  reducers: {
    setTitle: (state, action) => {
      state.title = action.payload;
    },
    setProblem: (state, action) => {
      state.problem = action.payload;
    },
    setTried: (state, action) => {
      state.tried = action.payload;
    },
  },
});

export const { setTitle, setProblem, setTried } = createQuestionSlice.actions;

export default createQuestionSlice;
