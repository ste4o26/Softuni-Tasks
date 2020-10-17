import homePage from './controlers/home.js';
import registerPage, { register } from './controlers/register.js';
import loginPage, { login } from './controlers/login.js';
import logout from './controlers/logout.js';
import createPage, { create } from './controlers/create.js';
import detailsPage, { like } from './controlers/details.js';
import deleteTrek from './controlers/delete.js';
import editPage, { edit } from './controlers/edit.js';
import profilePage from './controlers/profile.js'

window.addEventListener('load', run);

function run() {
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
    this.get('#/profile/:id', profilePage);

    this.post('#/register', (context) => { register.call(context) });
    this.post('#/login', (context) => { login.call(context) });

    this.get('#/create', createPage);
    this.get('#/details/:id', detailsPage);
    this.get('#/details/like/:id', like);
    this.get('#/delete/:id', deleteTrek);
    this.get('#/edit/:id', editPage)

    this.post('#/edit/:id', (context) => { edit.call(context) })
    this.post('#/create', (context) => { create.call(context) });

}