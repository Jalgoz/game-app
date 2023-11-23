import React from 'react';
import { Card, Header, Segment } from 'semantic-ui-react';
import { GameCard } from './GameCard';

export const GameList = ({ games }) => {
  const movieList = games?.map((game) => (
    <GameCard
      key={game.id}
      game={game}
      link={true}
    />
  ));

  return games?.length > 0 ? (
    <Card.Group
      doubling
      centered
    >
      {movieList}
    </Card.Group>
  ) : (
    <Segment
      padded
      color="blue"
    >
      <Header
        textAlign="center"
        as="h4"
      >
        No games
      </Header>
    </Segment>
  );
};
