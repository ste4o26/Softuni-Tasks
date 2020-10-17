import { registerUserPost, throwErrorIfBadRequest } from '../data.js';

export default async function () {
    this.partials = {
        navigation: await this.load('./templates/common/navigation.hbs'),
        registerForm: await this.load('./templates/user/register-form.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    };

    this.partial('./templates/user/register-page.hbs');
}

export async function registerUser(context) {
    if (this.params.password !== this.params.repeatPassword) {
        alert('Password does not match!');
        const inputs = Array.from(document.getElementsByTagName('input'));
        inputs.pop();
        inputs.map(input => input.value = '');
        return;
    }

    let result;
    try {
        console.log(this.params.username, this.params.password);
        result = await registerUserPost(this.params.username, this.params.password);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        return;
    }

    alert('You have been register successfully!');
    this.redirect('#/login');


}