import React from 'react';
import { Link } from 'react-router-dom';
import { Card, Image } from 'semantic-ui-react';

export const GameCard = ({ game, link }) => {

  const content = (
    <>
      <Image
        className="card-image"
        src={game.poster ? game.poster : ''}
        wrapped
        ui={false}
      />
      <Card.Content textAlign="center">
        <Card.Header>{game.name}</Card.Header>
      </Card.Content>
      <Card.Content>
        <Card.Description>
          Developer: <strong>{game.developer}</strong>
        </Card.Description>
        <Card.Description>
          Designers: <strong>{game.designers}</strong>
        </Card.Description>
        <Card.Description>
          Genre: <strong>{game.genre}</strong>
        </Card.Description>
        <Card.Description>
          Classification: <strong>{game.classification}</strong>
        </Card.Description>
        <Card.Description>
          Year: <strong>{game.year}</strong>
        </Card.Description>
      </Card.Content>
    </>
  );
  return !link ? (
    <Card>{content}</Card>
  ) : (
    <Card
      as={Link}
      to={`/games/${game.id}`}
    >
      {content}
    </Card>
  );
};
