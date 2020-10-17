import home from './controlers/home.js';
import about from './controlers/about.js';
import login, { loginUser } from './controlers/login.js';
import register, { registerUser } from './controlers/register.js';
import catalog from './controlers/teamCatalog.js';
import details from './controlers/teamDetails.js';
import create, { createTeam } from './controlers/createTeam.js';
import edit from './controlers/teamEdit.js';

window.addEventListener('load', solve)

function solve() {
    const app = Sammy('#main', function () {
        this.use('Handlebars', 'hbs');

        this.userData = {
            loggedIn: false,
            hasTeam: false,
            isOnTeam: false,
            isAuthor: false,
        };

        this.get('index.html', home);
        this.get('#/home', home);
        this.get('#/', home);

        this.get('#/about', about);
        this.get('#/login', login);
        this.get('#/register', register);
        this.get('#/catalog', catalog);
        this.get('#/catalog/:id', details);
        this.get('#/create', create);
        this.get('#/edit/:id', edit);

        this.post('#/register', (context) => { registerUser.call(context) });
        this.post('#/login', (context) => { loginUser.call(context) })
        this.post('#/create', (context) => { createTeam.call(context) })

    });
    app.run();
}