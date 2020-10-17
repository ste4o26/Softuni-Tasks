import { fetchTemplate, registerUser, loginUser } from './data.js';//my import   

window.addEventListener('load', solve);

async function solve(e) {
    await registerPartials(e);
    const main = document.getElementById('main');
    const app = Sammy('#main', pageRouter);
    app.run('#/');
}


function pageRouter(context) {
    this.get('#/home', loadHomePageHandler);
    // this.get('#/catalog', loadCatalogPageHandler);
    // this.get('#/about', loadAboutPageHandler);
    this.get('#/register', loadRegisterUserPageHandler);
    this.get('#/login', loadLoginUserPageHandler);
    // this.get('#/create-team', loadCreateTeamPageHandler);
    // this.get('#/edit-team', loadEditTeamPageHandler);
    // this.get('#/team-details', loadTeamDetailsPagesHandler);
}

async function registerPartials(e) {
    const headerPartialTemplateString = await fetchTemplate('common/header');
    Handlebars.registerPartial('header', headerPartialTemplateString);

    const footerPartialTemplateString = await fetchTemplate('common/footer');
    Handlebars.registerPartial('footer', footerPartialTemplateString);

    const registerFormPartialTemplateString = await fetchTemplate('register/registerForm');
    Handlebars.registerPartial('registerForm', registerFormPartialTemplateString);

    const loginFormPartialTemplateString = await fetchTemplate('login/loginForm');
    Handlebars.registerPartial('loginForm', loginFormPartialTemplateString);
}

async function loadHomePageHandler(context) {
    const templateString = await fetchTemplate('home/home');
    const template = Handlebars.compile(templateString);
    // this.swap()
    main.innerHTML = template({});//TODO content
}

async function loadRegisterUserPageHandler(context) {
    const templateString = await fetchTemplate('register/registerPage');
    const template = Handlebars.compile(templateString);
    main.innerHTML = template({});//TODO content and register user with username

    document.getElementById('registerBtn')
        .addEventListener('click', registerUserHandler);


}

async function registerUserHandler(e) {
    e.preventDefault();
    const user = {
        email: document.getElementById('username').value,
        password: document.getElementById('password').value,
        repeatPassword: document.getElementById('repeatPassword').value
    };

    validateUser(user, true);
    const data = await registerUser(user);
    console.log(data);
}

function validateUser(user, isRegister) {
    Object.keys(user).map(key => {
        if (user[key] === undefined || user[key].trim() === '') {
            throw new TypeError('All fields are required!');
        }
    });

    if (isRegister && (user.password !== user.repeatPassword)) {
        throw new Error('Your passwords doesnt match!')
    }
}


async function loadLoginUserPageHandler(context) {
    const templateString = await fetchTemplate('login/loginPage');
    const template = Handlebars.compile(templateString);
    main.innerHTML = template({});//TODO content

    document.getElementById('loginBtn')
        .addEventListener('click', loginUserHandler);
}


async function loginUserHandler(e) {
    e.preventDefault();
    const user = {
        login: document.getElementById('username').value,
        password: document.getElementById('password').value
    };

    console.log(user);

    validateUser(user, false);
    const data = await loginUser(user);
    console.log(data);
}


