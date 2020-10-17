import { loginUser, throwErrorIfBadRequest } from '../data.js';
import { displaySuccessMessage, displayErrorMessage } from '../notifications.js';


export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    };

    this.partial('./templates/user/login.hbs');
}

export async function login() {
    if (this.params.email === '' || this.params.password === '') {
        displayErrorMessage('All fields are require!');
        return;
    }

    let result;
    try {
        result = await loginUser(this.params.email, this.params.password);
        throwErrorIfBadRequest(result);
    } catch (error) {
        displayErrorMessage(error.message);
        this.redirect('#/login');
        return;
    }

    localStorage.setItem('email', result.email);
    localStorage.setItem('userToken', result['user-token']);
    localStorage.setItem('isLoggedIn', true);
    localStorage.setItem('userId', result.objectId);

    displaySuccessMessage('Login successful.');
    this.redirect('#/home');
}