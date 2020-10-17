import { getMovieById, deleteMovie, throwErrorIfBadRequest, isLoggedIn } from '../data.js';

export default async function () {
    isLoggedIn(this);

    let confirmation = confirm('Are you sure that you want to delete this movie');
    if (confirmation === false) {
        this.redirect('#/myMovies');
        return;
    }

    let result;
    try {
        result = await deleteMovie(this.params.id);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        return;
    }

    const movie = this.app.userData.movies
        .find((movie, index) => {
            if (movie.objectId === this.params.id) {
                movie.index = index;
                return movie;
            }
        });

    this.app.userData.movies.splice(movie.index, 1);
    this.redirect('#/my-movies');
}

