import { logoutUser } from '../firebase_models/firebase_users.js'

export default async function logout() {
    if (localStorage.getItem('isLoggedIn') === null) {
        alert('No user is currently logged in!');
        this.redirect('#/home');
        return;
    }

    const response = await logoutUser();

    localStorage.removeItem('email');
    localStorage.removeItem('isLoggedIn');
    localStorage.removeItem('userId');

    this.redirect('#/home');
}