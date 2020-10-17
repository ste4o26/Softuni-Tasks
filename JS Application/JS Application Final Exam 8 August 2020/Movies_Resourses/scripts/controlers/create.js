import { createMovie, throwErrorIfBadRequest } from '../data.js';
import { displaySuccessMessage, displayErrorMessage } from '../notifications.js';

export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }

    const context = {
        email: localStorage.getItem('email'),
        isLoggedIn: localStorage.getItem('isLoggedIn')
    }

    this.partial('./templates/domain/create.hbs', context);
}

export async function create() {
    if (this.params.name === '' || this.params.description === '' || this.params.imageUrl === '') {
        displayErrorMessage('Invalid inputs!')
        return;
    }

    const movie = {
        name: this.params.name,
        description: this.params.description,
        imageUrl: this.params.imageUrl,
        creator: localStorage.getItem('email'),
        peopleLiked: []
    };

    let result;
    try {
        result = await createMovie(movie);
        throwErrorIfBadRequest(result);
    } catch (error) {
        displayErrorMessage(error.message);
        return;
    }

    displaySuccessMessage('Created successfully!');
    this.redirect('#/home');
}