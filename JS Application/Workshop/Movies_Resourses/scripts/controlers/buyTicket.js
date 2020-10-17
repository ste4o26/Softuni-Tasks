import { editMoviePost, getMovieById, throwErrorIfBadRequest } from '../data.js';

export default async function () {
    let result;
    try {
        result = await getMovieById(this.params.id);
        throwErrorIfBadRequest(result);
        if (result.availableTickets < 1) {
            alert('There are no more tickets for this movie!');
            this.redirect('#/cinema');
            return;
        }

        result.availableTickets--;
        editMoviePost(this.params.id, result);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        return;
    }

    alert(`Successfully bought ticket for ${result.title}!`);
    this.redirect('#/home');
}