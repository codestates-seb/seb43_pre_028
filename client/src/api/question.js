import { createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

const BASE_URL = process.env.REACT_APP_BASE_URL;
// const BASE_URL = process.env.REACT_APP_BASE_URL;
console.log(BASE_URL);
// const BASE_URL = 'http://localhost:4000';

export const fetchAllQuestions = createAsyncThunk(
  'questions/getAllQuestions',
  async () => {
    const url = `${BASE_URL}/questions`;
    const response = await axios.get(url);

    try {
      if (response.status >= 200 && response.status < 300) {
        const fetchedAllQuestions = response.data;
        return fetchedAllQuestions;
      }
    } catch (error) {
      return Promise.reject(error);
    }

    return null;
  },
);

export default {};
