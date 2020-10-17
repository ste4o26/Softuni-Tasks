
const apiKey = 'AAD08D1C-3847-4369-ADEF-8C9FCCF1225D';
const appId = '13F0B2A2-384D-79F7-FFCF-FC533FF25100';

function getUrl(endpoint) {
    return `https://api.backendless.com/${appId}/${apiKey}/${endpoint}`;
}

const endpoints = {
    LOGIN: 'users/login',
    REGISTER: 'users/register',
    LOGOUT: 'users/logout',
    MOVIES: 'data/movies'
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

export async function createMovie(movie) {
    const response = await fetch(getUrl(endpoints.MOVIES), {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'user-token': localStorage.getItem('userToken')
        },
        body: JSON.stringify(movie)
    });

    const data = await response.json();
    return data;
}

export async function getAllMovies() {
    const response = await fetch(getUrl(endpoints.MOVIES), {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'user-token': localStorage.getItem('userToken')
        }
    });

    const data = await response.json();
    return data;
}

export async function deleteMovie(id) {
    const response = await fetch(getUrl(`${endpoints.MOVIES}/${id}`), {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
            'user-token': localStorage.getItem('userToken')
        }
    });

    const data = await response.json();
    return data;
}

export async function editMovie(movie) {
    const response = await fetch(getUrl(`${endpoints.MOVIES}/${movie.objectId}`), {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'user-token': localStorage.getItem('userToken')
        },
        body: JSON.stringify(movie)
    });

    const data = await response.json();
    return data;
}

export async function getMovieById(id) {
    const response = await fetch(getUrl(`${endpoints.MOVIES}/${id}`), {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'user-token': localStorage.getItem('userToken')
        }
    });

    const data = await response.json();
    return data;
}
