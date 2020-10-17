import { getAllPosts, throwErrorIfBadRequest } from '../data.js';

export default async function () {
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        post: await this.load('./templates/domain/post.hbs')
    }

    if (localStorage.getItem('isLoggedIn') === null) {
        this.partial('./templates/domain/home.hbs');
        return;
    }

    let result;
    try {
        result = await getAllPosts();
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        this.redirect('#/home');
        return;
    }


    const context = {
        isLoggedIn: localStorage.getItem('isLoggedIn'),
        email: localStorage.getItem('email'),
        userToken: localStorage.getItem('userToken'),
        posts: [...result]
    };

    this.partial('./templates/domain/home.hbs', context);
}