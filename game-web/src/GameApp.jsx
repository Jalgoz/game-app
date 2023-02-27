import React from 'react';
import { Outlet } from 'react-router-dom';
import { Navbar } from './components/Navbar';

export const GameApp = () => {
  return (
    <div className="container-app">
      <Navbar />

      <div className="ui divider"></div>

      <Outlet />
    </div>
  );
};
