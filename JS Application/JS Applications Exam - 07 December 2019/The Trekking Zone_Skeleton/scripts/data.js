const apiKey = 'DB3F0315-7935-4F5F-80B3-6F72B16970A6';
const appId = 'F8D267CC-944C-D563-FF87-342DECB3C000';

function getUrl(endpoint) {
    return `https://api.backendless.com/${appId}/${apiKey}/${endpoint}`;
}

const endpoints = {
    LOGIN: 'users/login',
    REGISTER: 'users/register',
    LOGOUT: 'users/logout',
    TREKS: 'data/treks'
}

export async function registerUser(username, password) {
    const response = await fetch(getUrl(endpoints.REGISTER), {
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

export async function loginUser(username, password) {
    const response = await fetch(getUrl(endpoints.LOGIN), {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            login: username,
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

export async function createTrek(trek) {
    const response = await fetch(getUrl(endpoints.TREKS), {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'user-token': localStorage.getItem('userToken')
        },
        body: JSON.stringify(trek)
    });

    const data = await response.json();
    return data;
}

export async function getAllTreks() {
    const response = await fetch(getUrl(endpoints.TREKS), {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'user-token': localStorage.getItem('userToken')
        }
    });

    const data = await response.json();
    return data;
}

export async function getTrekById(id) {
    const response = await fetch(`${getUrl(endpoints.TREKS)}/${id}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'user-token': localStorage.getItem('userToken')
        }
    });

    const data = await response.json();
    return data;
}

export async function editTrek(trek) {
    const response = await fetch(getUrl(`${endpoints.TREKS}/${trek.objectId}`), {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'user-token': localStorage.getItem('userToken')
        },
        body: JSON.stringify(trek)
    });

    const data = await response.json();
    return data;
}

export async function deleteTrek(id) {
    const response = await fetch(getUrl(`${endpoints.TREKS}/${id}`), {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
            'user-token': localStorage.getItem('userToken')
        }
    });

    const data = await response.json();
    return data;
}


export function throwErrorIfBadRequest(result) {
    if (result.hasOwnProperty('errorData')) {
        const error = new Error();
        Object.assign(error, result);
        throw error;
    }
}