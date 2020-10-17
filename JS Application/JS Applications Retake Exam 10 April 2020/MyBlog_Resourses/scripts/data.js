
const apiKey = '51D73166-0163-4824-916F-C5B49C1F2747';
const appId = '2A11BEA1-05FB-33F7-FF38-D4A820848500';

function getUrl(endpoint) {
    return `https://api.backendless.com/${appId}/${apiKey}/${endpoint}`;
}

const endpoints = {
    LOGIN: 'users/login',
    REGISTER: 'users/register',
    LOGOUT: 'users/logout',
    POSTS: 'data/posts'
}

export async function registerUser(email, password) {
    const response = await fetch(getUrl(endpoints.REGISTER), {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            email: email,
            password: password
        })
    });

    const data = await response.json();
    return data;
}

export async function loginUser(email, password) {
    const response = await fetch(getUrl(endpoints.LOGIN), {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            login: email,
            password: password
        })
    });

    //may need to set user token to localstorage from here 
    const data = await response.json();
    return data;
}

export async function logoutUser() {
    return await fetch(getUrl(endpoints.LOGOUT), {
        method: 'GET',
        headers: {
            'user-token': localStorage.getItem('userToken'),
            'Content-Type': 'application/json'
        }
    });
}

export function throwErrorIfBadRequest(result) {
    if (result.hasOwnProperty('errorData')) {
        const error = new Error();
        Object.assign(error, result);
        throw error;
    }
}

export async function createPost(post) {
    const response = await fetch(getUrl(endpoints.POSTS), {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'user-token': localStorage.getItem('userToken')
        },
        body: JSON.stringify(post)
    });

    const data = await response.json();
    return data;
}

export async function getAllPosts() {
    const response = await fetch(getUrl(endpoints.POSTS), {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'user-token': localStorage.getItem('userToken')
        }
    });

    const data = await response.json();
    return data;
}

export async function deletePost(id) {
    const response = await fetch(getUrl(`${endpoints.POSTS}/${id}`), {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
            'user-token': localStorage.getItem('userToken')
        }
    });

    const data = await response.json();
    return data;
}

export async function editPost(post) {
    const response = await fetch(getUrl(`${endpoints.POSTS}/${post.id}`), {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'user-token': localStorage.getItem('userToken')
        },
        body: JSON.stringify(post)
    });

    const data = await response.json();
    return data;
}

export async function getPostById(id) {
    const response = await fetch(getUrl(`${endpoints.POSTS}/${id}`), {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'user-token': localStorage.getItem('userToken')
        }
    });

    const data = await response.json();
    return data;
}
