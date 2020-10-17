import { logoutUser, throwErrorIfBadRequest } from "../data.js";

export default async function () {
    let result;
    try {
        result = await logoutUser();
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        this.redirect('#/home');
        return;
    }

    localStorage.removeItem('username');
    localStorage.removeItem('userToken');
    localStorage.removeItem('objectId');
    localStorage.removeItem('isLoggedIn');

    alert('Successfully logged out!');
    this.redirect('#/home');
}