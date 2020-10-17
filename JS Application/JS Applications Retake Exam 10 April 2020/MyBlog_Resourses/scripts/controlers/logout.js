import { logoutUser, throwErrorIfBadRequest } from '../data.js';

export default async function () {
    let result;
    try {
        result = await logoutUser();
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        return;
    }

    localStorage.removeItem('email');
    localStorage.removeItem('userToken');
    localStorage.removeItem('isLoggedIn');
    //object Id to add and remove as well!

    alert('Successfully logged out!');
    this.redirect('#/home');
}