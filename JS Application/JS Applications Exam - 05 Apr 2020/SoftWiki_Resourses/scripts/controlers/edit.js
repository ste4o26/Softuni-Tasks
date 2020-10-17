import { editArticle, throwErrorIfBadRequest, getArticleById } from '../data.js';

export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }

    try {
        let result = await getArticleById(this.params.id);
        throwErrorIfBadRequest(result);

        const context = {
            email: localStorage.getItem('email'),
            isLoggedIn: localStorage.getItem('isLoggedIn')
        }
        Object.assign(context, result)

        this.partial('./templates/domain/edit.hbs', context);
    } catch (error) {
        alert(error.message);
        this.redirect(`#/details/${result.objectId}`);
    }
}

export async function edit() {
    const confirmation = confirm('Are you sure you want to edit this article?');
    if (confirmation === false) {
        this.redirect(`#/details/${this.params.id}`);
        return;
    }

    let result;
    try {
        let article = {
            title: this.params.title,
            category: this.params.category,
            content: this.params.content,
            objectId: this.params.id
        }

        result = await editArticle(article);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        this.redirect(`#/details/${this.params.id}`);
        return;
    }


    alert(`You successfully edited article with title: ${result.title}`);
    this.redirect(`#/details/${result.objectId}`);
}