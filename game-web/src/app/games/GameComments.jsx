import React from 'react';
import { Header, Comment, Divider } from 'semantic-ui-react';

export const GameComments = ({ comments }) => {
  const height = window.innerHeight - 280;
  const style = {
    height: height,
    maxHeight: height,
    overflowY: 'auto',
    overflowX: 'hidden',
    maxWidth: 'none',
  };

  const commentList = comments.map((comment) => {
    return (
      <Comment key={comment.id}>
        <Comment.Content>
          <Comment.Author as="a">{comment.username}</Comment.Author>
          <Comment.Metadata>
            <div>{comment.timestamp}</div>
          </Comment.Metadata>
          <Comment.Text>{comment.comment}</Comment.Text>
        </Comment.Content>
      </Comment>
    );
  });

  return (
    <>
      <Header>Comments</Header>
      <Divider />
      <Comment.Group style={style}>{commentList}</Comment.Group>
    </>
  );
};
