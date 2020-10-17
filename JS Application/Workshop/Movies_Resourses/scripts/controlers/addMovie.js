import { addMoviePost, throwErrorIfBadRequest, isLoggedIn } from '../data.js';

export default async function () {
    isLoggedIn(this);

    this.partials = {
        navigation: await this.load('./templates/common/navigation.hbs'),
        addMovieForm: await this.load('./templates/movies/add-movie-form.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }

    this.partial('./templates/movies/add-movie-page.hbs', this.app.userData);
}

export async function addMovie() {

    const movie = {
        title: this.params.title,
        imageUrl: this.params.imageUrl,
        description: this.params.description,
        genres: this.params.genres,
        availableTickets: this.params.tickets
    }

    let result;
    try {
        result = await addMoviePost(movie);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        return;
    }


    this.app.userData.movies.push(movie);
    this.redirect('#/home');
}