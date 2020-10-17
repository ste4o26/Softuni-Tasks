import { getMovieById, throwErrorIfBadRequest, isLoggedIn } from '../data.js';

export default async function () {
    isLoggedIn(this);

    let result = this.app.userData.movies.find(movie => movie.objectId === this.params.id);
    if (result === undefined) {
        try {
            result = await getMovieById(this.params.id);
            throwErrorIfBadRequest(result);
        } catch (error) {
            alert(error.message);
            this.redirect('#/home');
            return;
        }

        this.app.userData.movies.push(result);
        Object.assign(result, this.app.userData);
    }

    this.partials = {
        navigation: await this.load('./templates/common/navigation.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    };


    this.partial('./templates/movies/movie-details.hbs', result);
}