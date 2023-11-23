import axios from 'axios';
import { config } from '../utils/Constants';

//TODO: Implement like in the applicant tracker app
const axiosInstance = axios.create({
  baseURL: config.url.API_BASE_URL,
});

axiosInstance.interceptors.response.use(
  (response) => {
    return response;
  },
  function (error) {
    if (error.response.status === 404) {
      return { status: error.response.status };
    }
    return Promise.reject(error.response);
  },
);

export default axiosInstance;
