const appId = '1C7B7EFD-E786-40F0-FF34-2B058351BD00';
const apiKey = '7688E6B3-201F-4DE9-B1D3-6A9F47223EBB';

function getHost(endPoint) {
    return `https://api.backendless.com/${appId}/${apiKey}/data/${endPoint}`;
}

function throwErrorIfBadRequest(response) {
    if (response.status >= 400) { throw new Error(`Status code: ${response.status}  -  Message: ${response.statusText}`) }
}

export async function fetchAllPlayers() {
    const respnse = await fetch(getHost('Players'));
    throwErrorIfBadRequest(respnse);
    const data = await respnse.json();
    return data;
}

export async function createPlayer(player) {
    const response = await fetch(getHost('Players'), {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(player)
    });
    throwErrorIfBadRequest(response);
    const data = await response.json();
    return data;
}

export async function deletePlayer(playerId) {
    const response = await fetch(getHost('Players').concat(`/${playerId}`), {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json' }
    });
    throwErrorIfBadRequest(response);
    const data = await response.json();
    return data;
}

export async function fetchSinglePlayer(playerId) {
    const response = await fetch(getHost('Players'.concat(`/${playerId}`)));
    throwErrorIfBadRequest(response);
    const data = await response.json();
    return data;
}

export async function savePlayersScore(player) {
    const response = await fetch(getHost('Players'), {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(player)
    });
    throwErrorIfBadRequest(response);
    const data = await response.json();
    return data;
}