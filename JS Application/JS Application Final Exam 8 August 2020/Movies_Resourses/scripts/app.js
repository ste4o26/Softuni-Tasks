import homePage from './controlers/home.js';
import registerPage, { register } from './controlers/register.js';
import loginPage, { login } from './controlers/login.js';
import logout from './controlers/logout.js';
import createPage, { create } from './controlers/create.js';
import details from './controlers/details.js';
import like from './controlers/like.js';
import editPage, { edit } from './controlers/edit.js';
import deleteMovie from './controlers/delete.js';

window.addEventListener('load', solve);

function solve() {
    const app = Sammy('#container', rooter);
    app.run();
}

function rooter() {
    this.use('Handlebars', 'hbs');

    this.get('#/', homePage);
    this.get('#/home', homePage);
    this.get('indexExam.html', homePage);

    this.get('#/create', createPage);
    this.post('#/create', (context) => { create.call(context) });

    this.get('#/edit/:id', editPage);
    this.post('#/edit/:id', (context) => { edit.call(context) });

    this.get('#/details/:id', details);

    this.get('#/like/:id', like);

    this.get('#/delete/:id', deleteMovie);


    this.get('#/register', registerPage);
    this.post('#/register', (context) => { register.call(context) });

    this.get('#/login', loginPage);
    this.post('#/login', (context) => { login.call(context) });

    this.get('#/logout', logout);






}