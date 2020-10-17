import { registerUserPost } from '../data.js';//my import   

export default async function (context) {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs'),
        registerForm: await this.load('./templates/register/registerForm.hbs')
    };

    this.partial('./templates/register/registerPage.hbs');
}

export async function registerUser(context) {
    if (this.params.password !== this.params.repeatPassword) {
        alert('Password does not match!');
        return;
    }

    try {
        const result = await registerUserPost(this.params.username, this.params.password);
        if (result.hasOwnProperty('errorData')) {
            const error = new Error();
            Object.assign(error, result);
            throw error;
        }

        this.redirect('#/login');
    } catch (error) {
        alert(error.message);
    }
}