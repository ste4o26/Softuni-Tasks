import { logoutUser, throwErrorIfBadRequest } from '../data.js';
import { displaySuccessMessage, displayErrorMessage } from '../notifications.js';


export default async function () {
    let result;
    try {
        result = await logoutUser();
        throwErrorIfBadRequest(result);
    } catch (error) {
        displayErrorMessages(error.message);
        return;
    }

    localStorage.removeItem('email');
    localStorage.removeItem('userToken');
    localStorage.removeItem('isLoggedIn');
    localStorage.removeItem('userId');

    displaySuccessMessage('Successful logout');
    this.redirect('#/home');
}