import { editMovie, throwErrorIfBadRequest, getMovieById } from '../data.js';
import { displaySuccessMessage, displayErrorMessage } from '../notifications.js';

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

    const context = {
        email: localStorage.getItem('email'),
        isLoggedIn: localStorage.getItem('isLoggedIn')
    }


    Object.assign(context, result);
    this.partial('./templates/domain/edit.hbs', context);
}

export async function edit() {
    if (this.params.name === '' || this.params.description === '' || this.params.imageUrl === '') {
        displayErrorMessage('All fields are required!');
        return;
    }

    const movie = {
        objectId: this.params.id,
        name: this.params.name,
        description: this.params.description,
        imageUrl: this.params.imageUrl
    }

    let result;
    try {
        result = await editMovie(movie);
        throwErrorIfBadRequest(result);
    } catch (error) {
        displayErrorMessage(error.message);
        this.redirect(`#/details/${this.params.id}`);
        return;
    }

    displaySuccessMessage('Eddited successfully');
    this.redirect(`#/details/${this.params.id}`);
}