# POC (springboot-react-keycloak-oauth2.0-pkce-hexagonal-architecture)

The goal of this project is to secure `game-app` using [`Keycloak`](https://www.keycloak.org/)(with PKCE). `game-app` consists of two applications: one is a [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/) Rest API called `game-api` and another is a [ReactJS](https://reactjs.org/) application called `game-web`.

## Summary

`game-app` is a web application to watch, create, update and delete our favorites games and comment these, we have three types of roles:

* `ADMIN`: They can watch, create, update, and delete games also they can comment on games and watch his profile.
* `USER`: They can watch the games, they can comment on games and watch his profile.
* `NON-REGISTER-USER`: They just can watch the existing games.

## Application

- ### game-api

  `Spring Boot` Web Java backend application that exposes a REST API to manage **games**. Its secured endpoints can just be accessed if an access token (JWT) issued by `Keycloak` is provided. It's implementing

  `game-api` is implemented using the [`hexagonal architecture`](https://github.com/thombergs/buckpal) 
  
  `game-api` stores its data in a [`MySQL`](https://www.mysql.com/) database.

  `game-api` has the following endpoints

  | Endpoint                                                          | Secured | Roles                       |
  |-------------------------------------------------------------------|---------|-----------------------------|
  | `GET /api/games`                                                  | No      |                             |
  | `GET /api/games/{id}`                                             | No      |                             |
  | `POST /api/games`                                                 | Yes     | `ADMIN`                     | 
  | `PUT /api/games`                                                  | Yes     | `ADMIN`                     | 
  | `DELETE /api/games`                                               | Yes     | `ADMIN`                     | 
  | `GET /api/users`                                                  | Yes     | `ADMIN` and `USER`          |
  | `POST /api/games/*/comments                                       | Yes     | `ADMIN` and `USER`          |

- ### game-ui

  `ReactJS` frontend application where `users` can watch and comment on games and `admins` can manage games. In order to access the application, `user` / `admin` must login using his/her username and password. Those credentials are handled by `Keycloak`. All the requests coming from `game-ui` to secured endpoints in `game-api` have a access token (JWT) that is generated when `user` / `admin` logs in.
  
  `game-ui` uses [`Semantic UI React`](https://react.semantic-ui.com/) as CSS-styled framework.

  ## Prerequisites

- [`Java 17+`](https://www.oracle.com/java/technologies/downloads/#java17)
- [`XAMPP`](https://www.apachefriends.org/es/download.html)
- [`npm`](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm)
- [`Docker`](https://www.docker.com/)

## Start Environment

- If you are using XAMPP, first create a database in [`phpMyAdmin`](http://localhost/phpmyadmin/) with a name
  ```
  world_gamer_db
  ```

- To run docker type this command in a terminal
  ```
  docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:21.0.0 start-dev
  ```
- Once the container is up enter to [`keycloak`](http://localhost:8080/admin/)


## The application ports

| Application | ports      |
|-------------|----------- |
| movie-api   | 9090       |
| movie-ui    | 3000       |
| Keycloak    | 8080       |
| MySQL       | 3306       |

## Running game-app

- **game-api**

  - Run the SpringSecurityApplication.java

    Once the startup finishes, `KeycloakInitializerRunner.java` class will run and initialize `world-game` realm in `Keycloak`. Basically, it will create:
    - Realm: `world-game`
    - Client: `game-app`
    - Client Roles: `ADMIN` and `USER`
    - Two users
      - `admin`: with roles `ADMIN` and `USER`
      - `user`: only with role `USER`

- **game-ui**

  - Open a terminal and navigate to `game-ui` folder

  - Run the command below if you are running the application for the first time
    ```
    npm install
    ```

  - Run the `npm` command below to start the application
    ```
    npm start
    ```