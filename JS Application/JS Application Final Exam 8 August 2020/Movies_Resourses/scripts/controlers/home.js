import { getAllMovies, throwErrorIfBadRequest } from '../data.js';
import { displayErrorMessage } from '../notifications.js';


export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }

    if (localStorage.getItem('isLoggedIn') === null) {
        this.partial('./templates/domain/home.hbs');
        return;
    }

    let result;
    try {
        result = await getAllMovies();
        throwErrorIfBadRequest(result);
    } catch (error) {
        displayErrorMessage(error.message);
        this.redirect('#/home');
        return;
    }

    if (this.params.search !== undefined && this.params.search.trim() !== '') {
        result = searchMoviesByTitle(this.params.search, result);
    }

    const context = {
        isLoggedIn: localStorage.getItem('isLoggedIn'),
        email: localStorage.getItem('email'),
        userToken: localStorage.getItem('userToken'),
        movies: [...result]
    };


    this.partial('./templates/domain/home.hbs', context);
}

function searchMoviesByTitle(title, allMovies) {
    return allMovies
        .filter(movie => movie.name.toLowerCase().includes(title.toLowerCase()))
        .map(movie => movie);
}