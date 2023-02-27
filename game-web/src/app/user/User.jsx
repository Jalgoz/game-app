import React, { useEffect, useState } from 'react';
import { Container, Segment, Grid, Card, Image } from 'semantic-ui-react';
import { useKeycloak } from '@react-keycloak/web';
import { getUser } from '../../service/user/UserApi';
import { handleLogError } from '../../utils/Helpers';

export const User = () => {
  const { keycloak } = useKeycloak();
  const [userState, setUserState] = useState([]);

  const componentMount = async () => {
    try {
      const response = await getUser(keycloak.token);
      const { username, createdDate } = response.data;
      setUserState({username, createdDate});
    } catch (error) {
      handleLogError(error);
    }
  };

  useEffect(() => {
    componentMount();
  }, []);

  return (
    <Container>
      <Grid centered>
        <Grid.Row>
          <Segment style={{ width: '330px' }}>
            <Card>
              <Image
                src="https://react.semantic-ui.com/images/avatar/large/matthew.png"
                wrapped
                ui={false}
              />
              <Card.Content>
                <Card.Header>{userState?.username}</Card.Header>
                <Card.Meta>
                  <span className="date">Joined in {userState?.createdDate}</span>
                </Card.Meta>
              </Card.Content>
            </Card>
          </Segment>
        </Grid.Row>
      </Grid>
    </Container>
  );
};
