import { getPostById, throwErrorIfBadRequest } from '../data.js';

export default async function () {
    let result;
    try {
        result = await getPostById(this.params.id);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        this.redirect('#/home');
        return;
    }

    const context = Object.assign({}, result);
    this.partial('./templates/domain/post-details.hbs', context);
}
