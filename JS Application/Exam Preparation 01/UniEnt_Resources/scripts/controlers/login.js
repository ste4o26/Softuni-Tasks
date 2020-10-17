import { loginUser } from '../firebase_models/firebase_users.js'
export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }

    this.partial('./templates/user/login.hbs');
}

export async function login() {
    if (this.params.email === '' || this.params.password === '') {
        alert('All fields are required!');
        return;
    }

    const response = await loginUser(this.params.email, this.params.password);

    localStorage.setItem('email', response.user.email);
    localStorage.setItem('userId', response.user.uid);
    localStorage.setItem('isLoggedIn', true);

    this.redirect('#/home');
}