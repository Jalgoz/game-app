import Keycloak from 'keycloak-js';
import { getUser, saveUser } from '../service/user/UserApi';
import { config } from '../utils/Constants';

export const keycloak = new Keycloak({
  url: config.url.KEYCLOAK_BASE_URL,
  realm: config.realm,
  clientId: config.clientId,
});
export const initOptionsKeycloak = { pkceMethod: 'S256' };

export const handleOnEvent = async (event, error) => {
  if (event === 'onAuthSuccess') {
    if (keycloak.authenticated) {
      let response = await getUser(keycloak.token);
      if (response.status === 404) {
        const user = { 
          username: keycloak.tokenParsed.preferred_username,
          email: keycloak.tokenParsed?.email ,
          name: keycloak.tokenParsed?.given_name + " " + keycloak.tokenParsed?.family_name ,
        };
        response = await saveUser(keycloak.token, user);
      }
    }
  }
};
