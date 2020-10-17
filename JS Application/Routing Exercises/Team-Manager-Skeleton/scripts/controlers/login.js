import { loginUserPost } from '../data.js';

export default async function (context) {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs'),
        loginForm: await this.load('./templates/login/loginForm.hbs')
    };

    this.partial('./templates/login/loginPage.hbs');
}

export async function loginUser(context) {

    try {
        const result = await loginUserPost(this.params.username, this.params.password);
        if (result.hasOwnProperty('errorData')) {
            const error = new Error();
            Object.assign(error, result);
            throw error;
        }

        this.app.userData.loggedIn = true;
        this.app.userData.username = result.username;
        this.app.userData.userId = result.objectId;

        // this.app.userData.hasTeam = false;
        // this.app.userData.isOnTeam = false;

        localStorage.setItem('userToken', result['user-token']);
        localStorage.setItem('userName', result.username);
        localStorage.setItem('userId', result.objectId);

        this.redirect('#/home');
    } catch (error) {
        alert(error.message);
    }

}