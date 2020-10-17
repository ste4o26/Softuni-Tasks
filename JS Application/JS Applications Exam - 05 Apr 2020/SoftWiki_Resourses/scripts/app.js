import homePage from './controlers/home.js';
import registerPage, { register } from './controlers/register.js';
import loginPage, { login } from './controlers/login.js';
import logout from './controlers/logout.js';
import createPage, { create } from './controlers/create.js';
import detailsPage from './controlers/details.js';
import editPage, { edit } from './controlers/edit.js';
import deleteArticle from './controlers/delete.js';


window.addEventListener('load', solve);

function solve() {
    const app = Sammy('#root', rooter);
    app.run();
}

function rooter() {
    this.use('Handlebars', 'hbs');

    this.get('#/', homePage);
    this.get('#/home', homePage);
    this.get('index.html', homePage);

    this.get('#/register', registerPage);
    this.get('#/login', loginPage);
    this.get('#/logout', logout);

    this.get('#/create', createPage);
    this.get('#/details/:id', detailsPage);
    this.get('#/edit/:id', editPage);


    this.post('#/register', (context) => { register.call(context) });
    this.post('#/login', (context) => { login.call(context) });

    this.post('#/create', (context) => { create.call(context) });
    this.post('#/edit/:id', (context) => { edit.call(context) });
    this.get('#/delete/:id', deleteArticle);

}