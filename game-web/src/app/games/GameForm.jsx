import React from 'react';
import { Button, Form } from 'semantic-ui-react';

const saveText = 'Save';
const updateText = 'Update';

export function GameForm({ form, handleChange, handlePersistenceGame, clearForm }) {
  const existId = form.id === null || form.id === undefined;
  const buttonText = existId ? saveText : updateText;
  const colorButton = buttonText === saveText ? 'green' : 'blue';

  return (
    <Form>
      <Form.Input
        fluid
        label="Name *"
        id="name"
        onChange={handleChange}
        value={form.name}
      />
      <Form.Input
        fluid
        label="Developer *"
        id="developer"
        onChange={handleChange}
        value={form.developer}
      />
      
      <Form.Input
        fluid
        label="Designers *"
        id="designers"
        onChange={handleChange}
        value={form.designers}
      />
      <Form.Input
        fluid
        label="Genre *"
        id="genre"
        onChange={handleChange}
        value={form.genre}
      />
      <Form.Input
        fluid
        label="Classification *"
        id="classification"
        onChange={handleChange}
        value={form.classification}
      />
      <Form.Input
        fluid
        label="Year *"
        id="year"
        onChange={handleChange}
        value={form.year}
      />
      <Form.Input
        fluid
        label="Poster *"
        id="poster"
        onChange={handleChange}
        value={form.poster}
      />
      <Button.Group fluid>
        <Button onClick={clearForm}>Cancel</Button>
        <Button.Or />
        <Button
          color={colorButton}
          onClick={() => handlePersistenceGame(form.id)}
        >
          {buttonText}
        </Button>
      </Button.Group>
    </Form>
  );
}
