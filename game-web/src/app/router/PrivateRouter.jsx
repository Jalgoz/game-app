import { useKeycloak } from '@react-keycloak/web';
import React from 'react';
import { Navigate } from 'react-router-dom';
import { isAdmin } from '../../utils/Helpers';

export const PrivateRouter = ({children, mustBeAdmin}) => {
  const { keycloak } = useKeycloak();
  let isAuthorized = keycloak.authenticated;

  if (mustBeAdmin) {
    isAuthorized = isAdmin(keycloak);
  }

  return isAuthorized ? children : <Navigate to="/" />;
};
