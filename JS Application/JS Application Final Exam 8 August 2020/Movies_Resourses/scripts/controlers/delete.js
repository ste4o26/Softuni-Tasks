import { deleteMovie, throwErrorIfBadRequest } from '../data.js';
import { displaySuccessMessage, displayErrorMessage } from '../notifications.js';

export default async function () {
    let result;
    try {
        result = await deleteMovie(this.params.id);
        throwErrorIfBadRequest(result);
    } catch (error) {
        displayErrorMessage(error.message);
        this.redirect('#/home');
        return;
    }

    displaySuccessMessage('Deleted successfully');
    this.redirect('#/home');
}