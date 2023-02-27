import axiosInstance from '../../api/ApiService';
import { bearerAuth } from '../../utils/Helpers';
import { path } from '../../utils/Constants';

const instance = axiosInstance;

export const getGames = () => {
  return instance.get(path.GAME);
};

export const getGameById = (id) => {
  return instance.get(`${path.GAME}/${id}`);
};

export const saveGame = (game, token) => {
  return instance.post(path.GAME, game, {
    headers: { Authorization: bearerAuth(token) },
  });
};

export const updateGame = (game, id, token) => {
  return instance.put(`${path.GAME}/${id}`, game, {
    headers: { Authorization: bearerAuth(token) },
  });
};

export const deleteGame = (id, token) => {
  return instance.delete(`${path.GAME}/${id}`, {
    headers: { Authorization: bearerAuth(token) },
  });
};

export const addGameComment = (comment, id, token) => {
  return instance.post(`${path.GAME}/${id}${path.COMMENT}`, comment, {
    headers: { Authorization: bearerAuth(token) },
  });
};
