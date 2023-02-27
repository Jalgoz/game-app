package com.jalgoz.springsecurity.common.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Path {

  public static final String USER = "/api/users";
  public static final String GAME = "/api/games";
  public static final String GAME_ALL = "/api/games/**";
  public static final String GAME_ID = "/api/games/{id}";
  public static final String COMMENTS = "/comments";
  public final static String COMMENTS_ID = Path.GAME + "/{id}" + Path.COMMENTS;
  public final static String COMMENTS_ID_ALLOWED = Path.GAME + "/*" + Path.COMMENTS;

}
