const apiKey = '2F5848B5-38AB-4017-915E-CEDFCB3EBE28';
const appId = 'EBDA5C66-BF68-C976-FFFD-894BFED11200';

function getUrl(endpoint) {
    return `https://api.backendless.com/${appId}/${apiKey}/${endpoint}`;
}

const endpoints = {
    LOGIN: 'users/login',
    REGISTER: 'users/register',
    LOGOUT: 'users/logout',
    ARTICLES: 'data/articles'
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

export async function createArticle(article) {
    const response = await fetch(getUrl(endpoints.ARTICLES), {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'user-token': localStorage.getItem('userToken')
        },
        body: JSON.stringify(article)
    });

    const data = await response.json();
    return data;
}

export async function getAllArticles() {
    const response = await fetch(getUrl(endpoints.ARTICLES), {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'user-token': localStorage.getItem('userToken')
        }
    });

    const data = await response.json();
    return data;
}

export async function deleteArticle(id) {
    const response = await fetch(getUrl(`${endpoints.ARTICLES}/${id}`), {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
            'user-token': localStorage.getItem('userToken')
        }
    });

    const data = await response.json();
    return data;
}

export async function editArticle(article) {
    const response = await fetch(getUrl(`${endpoints.ARTICLES}/${article.objectId}`), {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'user-token': localStorage.getItem('userToken')
        },
        body: JSON.stringify(article)
    });

    const data = await response.json();
    return data;
}

export async function getArticleById(id) {
    const response = await fetch(getUrl(`${endpoints.ARTICLES}/${id}`), {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'user-token': localStorage.getItem('userToken')
        }
    });

    const data = await response.json();
    return data;
}
