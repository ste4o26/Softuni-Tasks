import { registerUser, throwErrorIfBadRequest } from '../data.js';
import { displayErrorMessage, displaySuccessMessage } from '../notifications.js';

export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    };

    this.partial('./templates/user/register.hbs');
}


export async function register() {
    if (this.params.email === '' || this.params.password.length < 6 || this.params.repeatPassword.length < 6) {
        displayErrorMessage('All fields are required and password should be at least 6 symbols!');
        this.redirect('#/register')
        return;
    }

    if (this.params.password !== this.params.repeatPassword) {
        displayErrorMessage('Password does not match!');
        this.redirect('#/register');
        return;
    }

    let result;
    try {
        result = await registerUser(this.params.email, this.params.password);
        throwErrorIfBadRequest(result);
    } catch (error) {
        displayErrorMessage(error.message);
        this.redirect('#/register');
        return;
    }

    displaySuccessMessage('Successful registration!');
    this.redirect('#/home');
}