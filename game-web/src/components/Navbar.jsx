import { useKeycloak } from '@react-keycloak/web';
import React from 'react';
import { NavLink, useNavigate } from 'react-router-dom';
import { Dropdown, Menu, Segment } from 'semantic-ui-react';
import { isAdmin } from '../utils/Helpers';

export const Navbar = () => {
  const navigate = useNavigate();
  const { keycloak } = useKeycloak();

  const handleLogInOut = () => {
    if (keycloak.authenticated) {
      navigate('/');
      keycloak.logout();
    } else {
      keycloak.login();
    }
  };

  const checkAuthenticated = () => {
    if (!keycloak.authenticated) {
      handleLogInOut();
    }
  };

  const getUsername = () => {
    return (
      keycloak.authenticated && keycloak.tokenParsed && keycloak.tokenParsed.preferred_username
    );
  };

  const getLogInOutText = () => {
    return keycloak.authenticated ? 'Logout' : 'Login';
  };

  const getAdminMenuStyle = () => {
    return keycloak.authenticated && isAdmin(keycloak) ? { display: 'block' } : { display: 'none' };
  };

  return (
    <Segment inverted>
      <Menu
        inverted
        secondary
      >
        <Menu.Item header>World Gamer</Menu.Item>
        <Menu.Item
          as={NavLink}
          to="/home"
        >Home</Menu.Item>
        <Dropdown
          item
          text="Admin"
          style={getAdminMenuStyle()}
        >
          <Dropdown.Menu>
            <Dropdown.Item
              as={NavLink}
              to="/games"
              onClick={checkAuthenticated}
            >
              Games
            </Dropdown.Item>
          </Dropdown.Menu>
        </Dropdown>

        <Menu.Menu position="right">
          {keycloak.authenticated && (
            <Dropdown
              name="user"
              text={`Hi ${getUsername()}`}
              className="link item"
            >
              <Dropdown.Menu>
                <Dropdown.Item
                  as={NavLink}
                  to="/settings"
                >
                  Settings
                </Dropdown.Item>
              </Dropdown.Menu>
            </Dropdown>
          )}
          <Menu.Item
            as={NavLink}
            to="/"
            onClick={handleLogInOut}
          >
            {getLogInOutText()}
          </Menu.Item>
        </Menu.Menu>
      </Menu>
    </Segment>
  );
};
/* <Menu stackable>
      <Container>
        <Menu.Item header>World Gamer</Menu.Item>
        <Menu.Item
          as={NavLink}
          to="/home"
        >
          Home
        </Menu.Item>
        <Dropdown
          item
          text="Admin"
          style={getAdminMenuStyle()}
        >
          <Dropdown.Menu>
            <Dropdown.Item
              as={NavLink}
              to="/games"
              onClick={checkAuthenticated}
            >
              Games
            </Dropdown.Item>
          </Dropdown.Menu>
        </Dropdown>
        <Menu.Menu position="right">
          {keycloak.authenticated && (
            <Dropdown
              text={`Hi ${getUsername()}`}
              pointing
              className="link item"
            >
              <Dropdown.Menu>
                <Dropdown.Item
                  as={NavLink}
                  to="/settings"
                >
                  Settings
                </Dropdown.Item>
              </Dropdown.Menu>
            </Dropdown>
          )}
          <Menu.Item
            as={NavLink}
            to="/"
            onClick={handleLogInOut}
          >
            {getLogInOutText()}
          </Menu.Item>
        </Menu.Menu>
      </Container>
    </Menu> */
