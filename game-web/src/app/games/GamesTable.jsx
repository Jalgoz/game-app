import React from 'react';
import { Button, Image, Table } from 'semantic-ui-react';

export function GamesTable({ games, handleUpdateGame, handleDeleteGame }) {
  const height = window.innerHeight - 100;
  const style = {
    height: height,
    maxHeight: height,
    overflowY: 'auto',
    overflowX: 'hidden',
  };

  const gameList =
    games &&
    games.map((game) => {
      return (
        <Table.Row key={game.id}>
          <Table.Cell collapsing>
            <Button
              circular
              color="red"
              size="small"
              icon="trash"
              onClick={() => handleDeleteGame(game.id)}
            />
            <Button
              circular
              color="instagram"
              size="small"
              icon="edit"
              onClick={() => handleUpdateGame(game)}
            />
          </Table.Cell>
          <Table.Cell>{game.name}</Table.Cell>
          <Table.Cell>{game.developer}</Table.Cell>
          <Table.Cell>{game.designers}</Table.Cell>
          <Table.Cell>{game.genre}</Table.Cell>
          <Table.Cell>{game.classification}</Table.Cell>
          <Table.Cell>{game.year}</Table.Cell>
          <Table.Cell>
            <Image
              size="tiny"
              src={game.poster ? game.poster : '/images/movie-poster.jpg'}
              rounded
            />
          </Table.Cell>
        </Table.Row>
      );
    });

  return (
    <div style={style}>
      <Table
        compact
        striped
      >
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell width={2} />
            <Table.HeaderCell width={3}>Name</Table.HeaderCell>
            <Table.HeaderCell width={3}>Developer</Table.HeaderCell>
            <Table.HeaderCell width={2}>Designers</Table.HeaderCell>
            <Table.HeaderCell width={3}>Genre</Table.HeaderCell>
            <Table.HeaderCell width={1}>Classification</Table.HeaderCell>
            <Table.HeaderCell width={1}>Year</Table.HeaderCell>
            <Table.HeaderCell width={3}>Poster</Table.HeaderCell>
          </Table.Row>
        </Table.Header>
        <Table.Body>{gameList}</Table.Body>
      </Table>
    </div>
  );
}
