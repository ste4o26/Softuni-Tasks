import { isLoggedIn, throwErrorIfBadRequest, getAllMovies } from '../data.js';

export default async function () {
    isLoggedIn(this);

    this.partials = {
        navigation: await this.load('./templates/common/navigation.hbs'),
        search: await this.load('./templates/common/search-form.hbs'),
        movies: await this.load('./templates/movies/movies.hbs'),
        movie: await this.load('./templates/movies/movie.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }

    let result = this.app.userData.movies;
    try {
        result = await getAllMovies();
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        return;
    }

    if (this.params.search !== undefined && this.params.search.trim() !== '') {
        const searchedGenres = this.params.search.split(', ');
        result = getMoviesWithGenres(searchedGenres, result);
    }

    this.app.userData.movies = result;
    this.partial('./templates/movies/cinema.hbs', this.app.userData);
}

function getMoviesWithGenres(searchedGenres, allMovies) {
    return searchedGenres.reduce((acc, search) => {
        allMovies.map(movie => {
            movie.genres
                .split(', ')
                .map(genre => {
                    if (acc.find(item => item.title === movie.title) === undefined) {
                        if (genre.toLowerCase() === search.toLowerCase()) { acc.push(movie) }
                    }
                })
        })
        return acc;
    }, []);
}