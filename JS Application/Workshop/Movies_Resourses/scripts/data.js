const apiKey = '48FAB5B7-9F31-440B-9510-ADDD49E298D5';
const appId = 'FEF8E0CF-B773-785A-FF51-438DE5910600';

const endpoints = {
    MOVIES: 'data/movies',
    LOGIN: 'users/login',
    REGISTER: 'users/register',
    LOGOUT: 'users/logout'
};

function getUrl(endpoint) { return `https://api.backendless.com/${appId}/${apiKey}/${endpoint}` }

export async function loginUserPost(username, password) {
    const url = getUrl(endpoints.LOGIN);
    const response = await fetch(url, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            login: username,
            password: password
        })
    });

    const data = await response.json();
    return data;
}

export async function logoutUser(userToken) {
    const url = getUrl(endpoints.LOGOUT);
    const response = await fetch(url, {
        method: 'GET',
        headers: { 'user-token': userToken }
    });

    return response;
}

export async function registerUserPost(username, password) {
    const url = getUrl(endpoints.REGISTER);
    const response = await fetch(url, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            username: username,
            password: password
        })
    });

    const data = await response.json();
    return data;
}

export async function addMoviePost(movie) {
    const userToken = localStorage.getItem('userToken');
    const url = getUrl(endpoints.MOVIES);
    const response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'user-token': userToken
        },
        body: JSON.stringify(movie)
    });

    const data = await response.json();
    return data;
}

export async function getAllMovies() {
    const userToken = localStorage.getItem('userToken');
    const url = getUrl(endpoints.MOVIES);
    const response = await fetch(url, {
        method: 'GET',
        headers: { 'user-token': userToken }
    });

    const data = await response.json();
    return data;
}

export async function getMovieById(id) {
    const url = getUrl(`${endpoints.MOVIES}/${id}`);
    const response = await fetch(url);
    const data = await response.json();
    return data;
}


export function isLoggedIn(context) {
    const userToken = localStorage.getItem('userToken');
    if (userToken === null) {
        context.redirect('#/home');
        return;
    }

    context.app.userData.username = localStorage.getItem('username');
    context.app.userData.objectId = localStorage.getItem('objectId');
    context.app.userData.isLoggedIn = true;
}

export function throwErrorIfBadRequest(result) {
    if (result.hasOwnProperty('errorData')) {
        const error = new Error();
        Object.assign(error, result);
        throw error;
    }
}


export async function deleteMovie(id) {
    const userToken = localStorage.getItem('userToken');
    const url = getUrl(`${endpoints.MOVIES}/${id}`);
    const response = await fetch(url, {
        method: 'DELETE',
        headers: { 'user-token': userToken }
    });
    const data = await response.json();
    return data;
}

export async function editMoviePost(id, editedMovie) {
    const userToken = localStorage.getItem('userToken');
    const url = getUrl(`${endpoints.MOVIES}/${id}`);
    const response = await fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'user-token': userToken
        },
        body: JSON.stringify(editedMovie)
    });

    const data = await response.json();
    return data;
}