import React, { useEffect, useState } from 'react';
import { Container, Grid, Header, Segment, Icon, Divider } from 'semantic-ui-react';
import { formInitialState, isValidForm } from './utils/helpers';
import { useForm } from '../../hooks/useForm';
import { GamesTable } from './GamesTable';
import { GameForm } from './GameForm';
import { useGetGames } from './hooks/useGetGames';
import { useKeycloak } from '@react-keycloak/web';
import { deleteGame, saveGame, updateGame } from '../../service/game/GameApi';
import { handleLogError } from '../../utils/Helpers';
import ConfirmationModal from '../../components/ConfirmationModal';

const gameToDeleteState = {
  id: null,
  name: '',
}

export const GamesPage = () => {
  const { formState, setFormState, onInputChange, onResetForm } = useForm(formInitialState);
  const { componentMount, games } = useGetGames();
  const { keycloak } = useKeycloak();
  const [isOpen, setIsOpen] = useState(false);
  const [gameToDelete, setGameToDelete] = useState(gameToDeleteState);

  const onSaveGame = async (id = null) => {
    if (!isValidForm(formState)) {
      return;
    }

    const { name, developer, designers, genre, classification, year, poster } = formState;
    const game = { name, developer, designers, genre, classification, year: Number(year), poster };

    try {
      if (id === null || id === undefined) {
        await saveGame(game, keycloak.token);
      } else {
        await updateGame(game, id, keycloak.token);
      }

      onResetForm();
      componentMount();
    } catch (error) {
      handleLogError(error);
    }
  };

  useEffect(() => {
    componentMount();
  }, []);

  const onUpdateGame = (game) => {
    const editForm = {
      id: game.id,
      name: game.name,
      developer: game.developer,
      designers: game.designers,
      genre: game.genre,
      classification: game.classification,
      year: `${game.year}`,
      poster: game.poster,
    };
    setFormState(editForm);
  };

  const onDeleteGame = async (id, confirmation) => {
    if (confirmation) {
      if (id !== null && !id !== undefined) {
        console.log(id);
        try {
          await deleteGame(id, keycloak.token);
          componentMount();
        } catch (error) {
          handleLogError(error);
        }
      }
    }

    onHandleOpen();
  };

  const triggerDeleteGame = (id, name) => {
    setGameToDelete({id, name});
    onHandleOpen();
  }

  const onHandleOpen = () => {
    setIsOpen(!isOpen);
  };

  return (
    <Container>
      <Grid>
        <Grid.Column
          mobile={16}
          tablet={16}
          computer={4}
        >
          <Segment>
            <Header as="h2">
              <Icon name="gamepad" />
              <Header.Content>Game</Header.Content>
            </Header>
            <Divider />
            <GameForm
              form={formState}
              handleChange={onInputChange}
              handlePersistenceGame={onSaveGame}
              clearForm={onResetForm}
            />
          </Segment>
        </Grid.Column>
        <Grid.Column
          mobile={16}
          tablet={16}
          computer={12}
        >
          <GamesTable
            games={games}
            handleUpdateGame={onUpdateGame}
            handleDeleteGame={triggerDeleteGame}
          />
        </Grid.Column>
      </Grid>

      <ConfirmationModal
        isOpen={isOpen}
        header="Delete game"
        content={`Would you like to delete the game ${gameToDelete.name}`}
        onAction={onDeleteGame}
        idToDelete={gameToDelete.id}
        onHandleOpen={onHandleOpen}
      />
    </Container>
  );
};
