import React from 'react';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import { GameApp } from '../../GameApp';
import { GameDetail } from '../games/GameDetail';
import { GamesPage } from '../games/GamesPage';
import { Home } from '../home/Home';
import { User } from '../user/User';
import { PrivateRouter } from './PrivateRouter';

const router = createBrowserRouter([
  {
    path: '/',
    element: <GameApp />,
    children: [
      {
        path: '/home',
        element: <Home />,
      },
      {
        path: '/games/:id',
        element: <GameDetail />,
      },
      {
        path: '/games',
        element: <PrivateRouter mustBeAdmin={true}><GamesPage /></PrivateRouter>
      },
      {
        path: '/settings',
        element: <PrivateRouter mustBeAdmin={false}><User /></PrivateRouter>
      },
    ],
  },
]);

export const Router = () => <RouterProvider router={router} />;
