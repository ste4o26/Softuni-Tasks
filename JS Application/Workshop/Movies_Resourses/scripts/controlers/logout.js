import { logoutUser, throwErrorIfBadRequest } from '../data.js';

export default async function () {
    const userToken = localStorage.getItem('userToken');
    let result;
    try {
        result = await logoutUser(userToken);
    } catch (error) {
        alert(error.message);
        return;
    }

    this.app.userData.isLoggedIn = false;
    this.app.userData.username = undefined;
    this.app.userData.objectId = undefined;

    localStorage.removeItem('username');
    localStorage.removeItem('userToken');
    localStorage.removeItem('objectId');

    this.redirect('#/home');
}