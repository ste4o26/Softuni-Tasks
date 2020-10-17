import { createPost, throwErrorIfBadRequest } from '../data.js';

export default async function () {
    if (this.params.title === '' || this.params.category === '' || this.params.content === '') {
        alert('All fields are required!');
        return;
    }

    const post = {
        title: this.params.title,
        category: this.params.category,
        content: this.params.content
    };

    let result;
    try {
        result = await createPost(post);
        throwErrorIfBadRequest(result);
    } catch (error) {
        alert(error.message);
        return;
    }

    alert(`Succesfully create post with title: ${result.title}`);
    this.redirect('#/home');//later on do it to redirect on newly created post details!;
}