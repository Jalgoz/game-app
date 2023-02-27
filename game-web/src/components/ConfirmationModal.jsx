import React from 'react'
import { Button, Modal } from 'semantic-ui-react'

function ConfirmationModal({ isOpen, header, content, idToDelete, onHandleOpen, onAction }) {

  return (
    <Modal size='tiny' open={isOpen} onClose={onHandleOpen}>
      <Modal.Header>{header}</Modal.Header>
      <Modal.Content>
        <p>{content}</p>
      </Modal.Content>
      <Modal.Actions>
        <Button
          negative
          icon='thumbs down'
          content='No'
          onClick={() => onAction(idToDelete, false)}
        />
        <Button
          positive
          icon='thumbs up'
          labelPosition='right'
          content='Yes'
          onClick={() => onAction(idToDelete, true)}
        />
      </Modal.Actions>
    </Modal>
  )
}

export default ConfirmationModal