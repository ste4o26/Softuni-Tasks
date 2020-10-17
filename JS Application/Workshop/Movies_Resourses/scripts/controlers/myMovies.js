import { getAllMovies, throwErrorIfBadRequest, isLoggedIn } from '../data.js';

export default async function () {
    isLoggedIn(this);

    this.partials = {
        navigation: await this.load('./templates/common/navigation.hbs'),
        myMovie: await this.load('./templates/movies/my-movie.hbs'),
        footer: await this.load('./templates/common/footer.hbs'),
    };

    let result = this.app.userData.movies;
    if (result.length === 0) {
        try {
            result = await getAllMovies();
            throwErrorIfBadRequest(result);
        } catch (error) {
            alert(error.message);
            return;
        }
    }

    const myMovies = result.filter(movie => movie.ownerId === this.app.userData.objectId);
    this.app.userData.movies = myMovies;
    this.partial('./templates/movies/my-movies.hbs', this.app.userData);
}