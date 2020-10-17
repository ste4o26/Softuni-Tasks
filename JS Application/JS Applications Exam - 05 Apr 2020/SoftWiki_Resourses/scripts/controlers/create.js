import { createArticle, throwErrorIfBadRequest } from '../data.js'
export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }

    this.partial('./templates/domain/create.hbs');
}

export async function create() {
    if (this.params.title === '' || this.params.category === '' || this.params.content === '') {
        alert('All fields are required!');
        return;
    }

    const isValidCategory = this.params.category.toLowerCase() === 'javascript' ||
        this.params.category.toLowerCase() === 'js' ||
        this.params.category.toLowerCase() === 'pyton' ||
        this.params.category.toLowerCase() === 'java' ||
        this.params.category.toLowerCase() === 'csharp' ||
        this.params.category.toLowerCase() === 'c#';

    if (!isValidCategory) {
        alert('Not a valid category for our website!');
        this.redirect('#/create');
        return;
    }

    const article = {
        title: this.params.title,
        category: this.params.category,
        content: this.params.content
    };

    let result;
    try {
        result = await createArticle(article);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        this.redirect('#/create');
        return;
    }

    alert(`Successfully created article with title: ${result.title}`);
    this.redirect('#/home');
}