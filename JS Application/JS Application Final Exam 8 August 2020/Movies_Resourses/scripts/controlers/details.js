import { getMovieById, throwErrorIfBadRequest } from '../data.js';
import { displayErrorMessage } from '../notifications.js';

export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }


    let result;
    try {
        result = await getMovieById(this.params.id);
        throwErrorIfBadRequest(result);
    } catch (error) {
        displayErrorMessage(error.message);
        this.redirect('#/home');
        return;
    }

    const hasAlreadyLikedThisMovie = result.peopleLiked
        .find(email => email === localStorage.getItem('email')) !== undefined

    const context = {
        email: localStorage.getItem('email'),
        isLoggedIn: localStorage.getItem('isLoggedIn'),
        likes: result.peopleLiked.length,
        isCreator: result.creator === localStorage.getItem('email'),
        alreadyLiked: hasAlreadyLikedThisMovie
    };

    Object.assign(context, result);
    this.partial('./templates/domain/details.hbs', context);
}