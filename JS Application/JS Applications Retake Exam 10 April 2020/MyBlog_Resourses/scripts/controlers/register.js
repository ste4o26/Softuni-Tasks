import { registerUser, throwErrorIfBadRequest } from '../data.js';

export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs')
    };

    this.partial('./templates/user/register.hbs');
}


export async function register() {
    if (this.params.email === '' || this.params.password.length < 3 || this.params.repeatPassword.length < 3) {
        alert('All fields are required and password should be at least 3 symbols!');
        this.redirect('#/register')
        return;
    }

    if (this.params.password !== this.params.repeatPassword) {
        alert('Password does not match!');
        this.redirect('#/register');
        return;
    }

    let result;
    try {
        result = await registerUser(this.params.email, this.params.password);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        return;
    }

    alert('You have registered successfully!');
    this.redirect('#/login');
}