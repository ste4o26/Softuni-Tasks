import { isLoggedIn, throwErrorIfBadRequest, getMovieById, editMoviePost } from '../data.js';

export default async function () {
    isLoggedIn(this);

    this.partials = {
        navigation: await this.load('./templates/common/navigation.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }

    let result;
    try {
        result = await getMovieById(this.params.id);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        return
    }

    Object.assign(result, this.app.userData);

    this.partial('./templates/movies/edit-movie.hbs', result);
}

export async function editMovie() {
    let confirmation = confirm('Are you sure you want to edit this movie?');
    if (confirmation === false) {
        this.redirect('#/my-movies');
        return;
    }

    const editedMovie = {
        title: this.params.title,
        imageUrl: this.params.imageUrl,
        description: this.params.description,
        availableTickets: this.params.availableTickets,
        genres: this.params.genres
    };

    let result;
    try {
        result = await editMoviePost(this.params.id, editedMovie);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        return;
    }

    alert(`The movie with title ${result.title} has been updated successfully!`);
    this.redirect('#/my-movies');

}

