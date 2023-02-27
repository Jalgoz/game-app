import { useKeycloak } from '@react-keycloak/web';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Container, Grid } from 'semantic-ui-react';
import { addGameComment, getGameById } from '../../service/game/GameApi';
import { handleLogError } from '../../utils/Helpers';
import { GameCard } from '../home/GameCard';
import { GameCommentForm } from './GameCommentForm';
import { GameComments } from './GameComments';

const initialState = {
  authenticated: false,
  game: null,
};

export const GameDetail = () => {
  const gameParams = useParams();
  const { keycloak } = useKeycloak();
  const [state, setState] = useState(initialState);
  const [commentState, setCommentState] = useState('');
  const gameId = gameParams.id;
  const authenticated = keycloak.authenticated;

  const componentMount = async () => {
    try {
      const response = await getGameById(gameId);
      const game = response.data;
      setState({ ...state, authenticated, game });
    } catch (error) {
      handleLogError(error);
    }
  };

  useEffect(() => {
    componentMount();
  }, []);

  const handleChange = (event) => {
    const { value } = event.target;
    setCommentState(value);
  };

  const handleAddComment = async () => {
    if (!commentState) {
      return;
    }

    let { game } = state;
    const comment = {
      comment: commentState,
    }
    try {
      console.log(keycloak.authenticated);
      console.log(keycloak.token);
      const response = await addGameComment(comment, game.id, keycloak.token);
      game = response.data;
      setCommentState('');
      componentMount();
    } catch (error) {
      handleLogError(error);
    }
  };

  return !state.game ? (
    <></>
  ) : (
    <Container>
      <Grid
        columns={2}
        stackable
      >
        <Grid.Row>
          <Grid.Column width={5}>
            <GameCard
              game={state.game}
              link={false}
            />
          </Grid.Column>
          <Grid.Column width={11}>
            <GameCommentForm
              authenticated={state.authenticated}
              commentText={commentState}
              handleAddComment={handleAddComment}
              handleChange={handleChange}
            />
            <GameComments comments={state.game.commentList} />
          </Grid.Column>
        </Grid.Row>
      </Grid>
    </Container>
  );
};
