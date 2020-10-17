import { getAllArticles, throwErrorIfBadRequest } from "../data.js";

export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        category: await this.load('./templates/domain/category.hbs'),
        article: await this.load('./templates/domain/article.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    }

    let result;
    try {
        result = await getAllArticles();
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        this.redirect('#/home');
        return;
    }

    const context = {
        username: localStorage.getItem('email'),
        isLoggedIn: localStorage.getItem('isLoggedIn'),
    };

    Object.assign(context, sortByCategory(result));
    this.partial('./templates/domain/home.hbs', context);
}


function sortByCategory(articles) {
    const javaArticles = articles
        .filter(article => article.category.toLowerCase() === 'java')
        .sort((f, s) => f.title.localeCompare(s.title));

    const jsArticles = articles
        .filter(article => article.category.toLowerCase() === 'javascript' || article.category === 'js')
        .sort((f, s) => f.title.localeCompare(s.title));

    const cSharpArticles = articles
        .filter(article => article.category.toLowerCase() === 'csharp' || article.category.toLowerCase() === 'c#')
        .sort((f, s) => f.title.localeCompare(s.title));

    const pytonArticles = articles
        .filter(article => article.category.toLowerCase() === 'pyton')
        .sort((f, s) => f.title.localeCompare(s.title));

    return {
        javaArticles,
        jsArticles,
        cSharpArticles,
        pytonArticles
    };
}