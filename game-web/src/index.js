import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import 'semantic-ui-css/semantic.min.css';
import { Router } from './app/router/Router';
import { ReactKeycloakProvider } from '@react-keycloak/web';
import { handleOnEvent, initOptionsKeycloak, keycloak } from './security/Keycloak';
import { LoadingComponent } from './components/LoadingComponent';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <ReactKeycloakProvider
    authClient={keycloak}
    initOptions={initOptionsKeycloak}
    LoadingComponent={<LoadingComponent />}
    onEvent={(event, error) => handleOnEvent(event, error)}
  >
      <Router />
  </ReactKeycloakProvider>,
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
