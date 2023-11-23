export const config = {
  url: {
    KEYCLOAK_BASE_URL: 'http://localhost:8080',
    API_BASE_URL: 'http://localhost:9090/api',
  },
  realm: 'world-game-app',
  clientId: 'game-app',
};

export const path = {
  USER: '/users',
  GAME: '/games',
  COMMENT: '/comments',
};

export const ROLE_ADMIN = 'ADMIN';
export const ROLE_USER = 'USER';
