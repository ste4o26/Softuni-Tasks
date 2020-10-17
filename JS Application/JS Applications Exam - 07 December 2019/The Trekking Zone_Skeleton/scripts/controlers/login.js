import { loginUser, throwErrorIfBadRequest } from '../data.js';

export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs'),
    };

    this.partial('./templates/user/login.hbs');
}

export async function login() {
    if (this.params.username === '' || this.params.password === '') {
        alert('All fields are require!');
        return;
    }

    let result;
    try {
        result = await loginUser(this.params.username, this.params.password);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        return;
    }

    localStorage.setItem('username', result.username);
    localStorage.setItem('userToken', result['user-token']);
    localStorage.setItem('userId', result.objectId);
    localStorage.setItem('isLoggedIn', true);

    alert('You have logged in successfully!');
    this.redirect('#/home');
}