import { useState } from "react";
import { getGames } from "../../../service/game/GameApi";
import { handleLogError } from "../../../utils/Helpers";

const initialState = {
  isLoading: false,
  games: [],
};

export const useGetGames = () => {
  const [state, setState] = useState(initialState);

  const componentMount = async () => {
    setState({ ...state, isLoading: true });
    try {
      const response = await getGames();
      const games = response.data;
      setState({ games, isLoading: false });
    } catch (error) {
      handleLogError(error)
    }
  };

  return {
    componentMount,
    ...state
  }
};