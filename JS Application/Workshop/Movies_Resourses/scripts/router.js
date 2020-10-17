import homePage from './controlers/home.js';
import registerPage, { registerUser } from './controlers/register.js';
import loginPage, { loginUser } from './controlers/login.js';
import logout from './controlers/logout.js';
import cinemaPage from './controlers/cinema.js';
import myMoviesPage from './controlers/myMovies.js';
import addMoviePage, { addMovie } from './controlers/addMovie.js';
import deleteMovie from './controlers/deleteMovie.js';
import editMoviePage, { editMovie } from './controlers/editMovie.js';
import movieDetails from './controlers/details.js';
import buyTicket from './controlers/buyTicket.js';

export default function () {
    this.userData = {
        isLoggedIn: false,
        movies: []
    };

    this.use('Handlebars', 'hbs');

    this.get('#/', homePage);
    this.get('#/home', homePage);
    this.get('index.html', homePage);

    this.get('#/register', registerPage);
    this.get('#/login', loginPage);
    this.get('#/logout', logout);

    this.get('#/cinema', cinemaPage);
    this.get('#/my-movies', myMoviesPage);
    this.get('#/add-movie', addMoviePage);
    this.get('#/delete-movie/:id', deleteMovie);
    this.get('#/edit-movie/:id', editMoviePage);
    this.get('#/movie-details/:id', movieDetails);
    this.get('#/buy-ticket/:id', buyTicket);
    this.get('#/search-movies', cinemaPage);

    this.post('#/register', (context) => { registerUser.call(context) });
    this.post('#/login', (context) => { loginUser.call(context) });
    this.post('#/add-movie', (context) => { addMovie.call(context) });
    this.post('#/edit-movie/:id', (context) => { editMovie.call(context) });
}
