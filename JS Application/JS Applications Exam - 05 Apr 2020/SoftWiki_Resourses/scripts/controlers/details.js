import { getArticleById, throwErrorIfBadRequest } from "../data.js";

export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }

    let result;
    try {
        result = await getArticleById(this.params.id);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        this.redirect('#/home');
        return;
    }

    const context = {
        username: localStorage.getItem('emial'),
        isLoggedIn: localStorage.getItem('isLoggedIn'),
    };

    Object.assign(context, result);
    this.partial('./templates/domain/details.hbs', context);
}