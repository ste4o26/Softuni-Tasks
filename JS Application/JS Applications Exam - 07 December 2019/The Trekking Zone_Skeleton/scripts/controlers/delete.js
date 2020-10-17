import { throwErrorIfBadRequest, deleteTrek } from '../data.js';

export default async function () {
    const confirmation = confirm('Are you sure you want to delete this trek?');
    if (confirmation === false) {
        this.redirect(`#/details/${this.params.id}`);
        return;
    }

    try {
        let result = await deleteTrek(this.params.id);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
    }

    this.redirect(`#/home`);
}