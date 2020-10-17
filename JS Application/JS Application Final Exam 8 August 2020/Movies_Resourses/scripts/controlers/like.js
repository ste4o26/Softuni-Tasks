import { getMovieById, throwErrorIfBadRequest, editMovie } from "../data.js";
import { displaySuccessMessage, displayErrorMessage } from "../notifications.js";

export default async function () {
    try {
        const movie = await getMovieById(this.params.id);
        throwErrorIfBadRequest(movie);

        const hasAlreadyLikedThisMovie = movie.peopleLiked
            .find(email => email === localStorage.getItem('email')) !== undefined

        if (hasAlreadyLikedThisMovie) { return }

        movie.peopleLiked.push(localStorage.getItem('email'));
        const result = await editMovie(movie);
        throwErrorIfBadRequest(result);
    } catch (error) {
        displayErrorMessage(error.message);
        this.redirect(`#/details/${this.params.id}`);
        return;
    }

    displaySuccessMessage('Liked successfully');
    this.redirect(`#/details/${this.params.id}`);
}