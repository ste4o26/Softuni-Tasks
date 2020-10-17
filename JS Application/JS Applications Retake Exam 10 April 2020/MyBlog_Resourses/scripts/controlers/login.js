import { loginUser, throwErrorIfBadRequest } from '../data.js';

export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs')
    };

    this.partial('./templates/user/login.hbs');
}

export async function login() {
    if (this.params.email === '' || this.params.password === '') {
        alert('All fields are require!');
        return;
    }

    let result;
    try {
        result = await loginUser(this.params.email, this.params.password);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        return;
    }

    localStorage.setItem('email', result.email);
    localStorage.setItem('userToken', result['user-token']);
    localStorage.setItem('isLoggedIn', true);

    alert('You have logged in successfully!');
    this.redirect('#/home');
}