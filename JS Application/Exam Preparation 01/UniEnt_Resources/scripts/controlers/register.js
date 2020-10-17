import { registerUser, loginUser } from '../firebase_models/firebase_users.js'

export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }

    this.partial('./templates/user/register.hbs');
}

export async function register() {
    if (this.params.email === '' || this.params.password === '' || this.params.rePassword === '') {
        alert('All fields are required!');
        return;
    }

    if (this.params.password !== this.params.rePassword) {
        alert('Password does not match!');
        return;
    }

    const registerResponse = await registerUser(this.params.email, this.params.password);
    const loginResponse = await loginUser(this.params.email, this.params.password);

    localStorage.setItem('email', loginResponse.user.email);
    localStorage.setItem('userId', loginResponse.user.uid);
    localStorage.setItem('isLoggedIn', true);
    this.redirect('#/home');
}