const appId = 'FF019AF7-2D7D-1A38-FFF4-18D823B75800';
const apiKey = 'AFEBA677-E5B5-488C-B6D4-2AC30BB9FD47';

const endpoints = {
    REGISTER: 'users/register',
    LOGIN: 'users/login',
    TEAMS: 'data/teams',
    UPDATE_USER: 'users/'
}

function getUrl(endPoint) {
    return `https://api.backendless.com/${appId}/${apiKey}/${endPoint}`;
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

export async function createTeamPost(name, comment) {
    const token = localStorage.getItem('userToken');
    if (token === null) { throw new Error('User is not logged in!') }

    const url = getUrl(endpoints.TEAMS)
    const response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'user-token': token
        },
        body: JSON.stringify({
            name: name,
            comment: comment

        })
    });

    const data = await response.json();

    if (data.hasOwnProperty('errorData')) {
        const error = new Error();
        Object.assign(error, data);
        throw error;
    }

    const updatedUser = await setUserTeamId(data.ownerId, data.objectId);
    if (updatedUser.hasOwnProperty('errorData')) {
        const error = new Error();
        Object.assign(error, data);
        throw error;
    }
    return data;
}


async function setUserTeamId(userId, teamId) {
    const token = localStorage.getItem('userToken');
    if (token === null) { throw new Error('User is not logged in!') }

    const url = getUrl(`${endpoints.UPDATE_USER}${userId}`);
    const response = await fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'user-token': token,
        },
        body: JSON.stringify({ teamId: teamId })
    });

    const data = await response.json();
    return data;
}

export async function getTeamById(teamId) {
    console.log(teamId);
    const url = getUrl(`${endpoints.TEAMS}/${teamId}`);
    const response = await fetch(url);
    const data = await response.json();
    return data;
}

export async function getTeams() {
    const url = getUrl(endpoints.TEAMS);
    const response = await fetch(url);
    const data = response.json();
    return data;
}