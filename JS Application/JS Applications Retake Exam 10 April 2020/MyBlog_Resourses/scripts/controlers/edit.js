import { editPost, throwErrorIfBadRequest, getPostById } from '../data.js';

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

    this.partial('./templates/domain/edit-post.hbs', result);
}

export async function edit() {
    if (this.params.title === '' || this.params.category === '' || this.params.content === '') {
        alert('All fields are required!');
        return;
    }

    const post = {
        id: this.params.id,
        title: this.params.title,
        category: this.params.category,
        content: this.params.content
    };

    const confirmation = confirm('Are you sure you want to edit this article?')
    if (confirmation === false) {
        this.redirect('#/home');
        return;
    }

    let result;
    try {
        result = await editPost(post);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        this.redirect('#/home');
        return;
    }

    this.redirect('#/home');
}