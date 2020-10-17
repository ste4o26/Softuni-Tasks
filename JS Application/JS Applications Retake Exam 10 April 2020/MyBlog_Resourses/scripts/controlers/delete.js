import { deletePost, throwErrorIfBadRequest } from '../data.js';

export default async function () {
    const confirmation = confirm('Are you sure you want to delete this article?')
    if (confirmation === false) {
        this.redirect('#/home');
        return;
        }

    let result;
    try {
        result = await deletePost(this.params.id);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        this.redirect('#/home');
        return;
    }

    this.redirect('#/home');
}