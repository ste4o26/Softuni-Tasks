import homePage from './controlers/home.js';
import registerPage, { register } from './controlers/register.js';
import loginPage, { login } from './controlers/login.js';
import logout from './controlers/logout.js';
import createPost from './controlers/create.js';
import deletePost from './controlers/delete.js';
import editPage, { edit } from './controlers/edit.js';
import details from './controlers/details.js';

window.addEventListener('load', solve);

function solve() {
    const app = Sammy('#root', rooter);
    app.run();
}

function rooter() {
    this.use('Handlebars', 'hbs');

    this.userData = {
        isLoggedIn: false,
        userName: ''
    }

    this.get('#/', homePage);
    this.get('#/home', homePage);
    this.get('index.html', homePage);

    this.get('#/register', registerPage);
    this.get('#/login', loginPage);
    this.get('#/logout', logout);

    this.post('#/register', (context) => { register.call(context) });
    this.post('#/login', (context) => { login.call(context) });

    this.get('#/details/:id', details);
    this.get('#/delete/:id', deletePost);
    this.get('#/edit/:id', editPage);
    this.post('#/edit/:id', (context) => { edit.call(context) });
    this.post('#/create-post', (context) => { createPost.call(context) });

}