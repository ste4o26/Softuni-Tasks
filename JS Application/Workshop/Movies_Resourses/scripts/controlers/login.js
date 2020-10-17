import { loginUserPost, throwErrorIfBadRequest } from "../data.js";

export default async function () {
    this.partials = {
        navigation: await this.load('./templates/common/navigation.hbs'),
        loginForm: await this.load('./templates/user/login-form.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    };

    this.partial('./templates/user/login-page.hbs');
}


export async function loginUser() {
    let result;
    try {
        result = await loginUserPost(this.params.username, this.params.password);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        return;
    }

    this.app.userData.isLoggedIn = true;
    this.app.userData.username = result.username;
    this.app.userData.objectId = result.objectId;

    localStorage.setItem('username', result.username);
    localStorage.setItem('userToken', result['user-token']);
    localStorage.setItem('objectId', result.objectId);

    this.redirect('#/home');
}
