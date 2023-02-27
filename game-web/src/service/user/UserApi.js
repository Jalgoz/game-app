import axiosInstance from '../../api/ApiService';
import { bearerAuth } from '../../utils/Helpers';
import { path } from '../../utils/Constants';

const instance = axiosInstance;

export const getUser = (token) => {
  return instance.get(path.USER, {
    headers: { Authorization: bearerAuth(token) },
  });
};

export const saveUser = (token, user) => {
  return instance.post(path.USER, user, {
    headers: { Authorization: bearerAuth(token) },
  });
};
