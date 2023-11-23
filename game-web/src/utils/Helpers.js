import { config, ROLE_ADMIN } from './Constants';

export const bearerAuth = (token) => {
  return `Bearer ${token}`;
};

export const isAdmin = (keycloak) => {
  return (
    keycloak &&
    keycloak.tokenParsed &&
    keycloak.tokenParsed.resource_access[config.clientId] &&
    keycloak.tokenParsed.resource_access[config.clientId].roles.includes(
      ROLE_ADMIN,
    )
  );
};

export const handleLogError = (error) => {
  if (error.response) {
    console.log(error.response.data);
  } else if (error.request) {
    console.log(error.request);
  } else {
    console.log(error.message);
  }
};
