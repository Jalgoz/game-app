import React from 'react';
import { Dimmer, Header, Icon } from 'semantic-ui-react';

export const LoadingComponent = () => {
  return (
    <Dimmer
      inverted
      active={true}
      page
    >
      <Header
        style={{ color: '#4d4d4d' }}
        as="h2"
        icon
        inverted
      >
        <Icon
          loading
          name="cog"
        />
        <Header.Content>
          Keycloak is loading
          <Header.Subheader style={{ color: '#4d4d4d' }}>
            or running authorization code flow with PKCE
          </Header.Subheader>
        </Header.Content>
      </Header>
    </Dimmer>
  );
};
