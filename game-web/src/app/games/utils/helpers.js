export const formInitialState = {
  name: '',
  developer: '',
  designers: '',
  genre: '',
  classification: '',
  year: '',
  poster: '',
};

export const modalInitialState = {
  isOpen: false,
  header: '',
  content: '',
  onAction: null,
  onClose: null,
};

export const isValidForm = (form) => {
  const nameError = form.name.trim() === '';
  const developerError = form.developer.trim() === '';
  const designersError = form.designers.trim() === '';
  const genreError = form.genre.trim() === '';
  const classificationError = form.classification.trim() === '';
  const yearError = form?.year?.trim() === '';
  const posterError = form.poster.trim() === '';

  const isValid =
    !nameError &&
    !developerError &&
    !designersError &&
    !genreError &&
    !classificationError &&
    !yearError &&
    !posterError;

  return isValid;
};
