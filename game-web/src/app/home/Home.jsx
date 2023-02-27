import React, { useEffect } from 'react';
import { Container } from 'semantic-ui-react';
import { useGetGames } from '../games/hooks/useGetGames';
import { GameList } from './GameList';

export const Home = () => {
  const { componentMount, isLoading, games } = useGetGames();

  useEffect(() => {
    componentMount();
  }, [])
  

  return isLoading ? (
    <></>
  ) : (
    <Container>
      <GameList games={games} />
    </Container>
  );
};
