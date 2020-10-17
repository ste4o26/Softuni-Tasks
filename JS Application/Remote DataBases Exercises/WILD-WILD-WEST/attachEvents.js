//If play button is pressed whenever some player is already playing the canvas is going to go crazy :D!!!
//If the delete button is pressed and then the save button is pressed its gonna throw an 404 error => fixed with button diable!!!

import * as api from './HttpRequestApi.js';
import * as dom from './dom.js';

window.addEventListener('load', attachEvents);

function attachEvents() {
    const createBtn = document.getElementById('addPlayer');
    createBtn.addEventListener('click', createNewPlayerHandler);
    displayPlayers();
}

async function displayPlayers() {
    const playersContainer = document.getElementById('players');
    const players = await api.fetchAllPlayers();
    players.forEach(player => {
        const playerDiv = dom.renderPlayer(player);
        playerDiv.id = player.objectId;
        playerDiv.querySelector('.play').addEventListener('click', startPlayingHandler);
        playerDiv.querySelector('.delete').addEventListener('click', deletePlayerHandler)
        playersContainer.appendChild(playerDiv);
    });
}

async function createNewPlayerHandler(e) {
    const elements = {
        playerName: () => document.getElementById('addName').value,
        players: () => document.getElementById('players')
    }

    const player = {
        name: elements.playerName(),
        money: 500,
        bullets: 6
    }

    const playerData = await api.createPlayer(player);
    const playerDiv = dom.renderPlayer(player);
    playerDiv.id = playerData.objectId;
    elements.players().appendChild(playerDiv);
}

async function startPlayingHandler(e) {
    const id = e.target.parentElement.id;
    document.getElementById(id).querySelector('.delete').disabled = 'true';

    const player = await api.fetchSinglePlayer(id);


    const elements = {
        canvas: () => document.getElementById('canvas'),
        saveBtn: () => document.getElementById('save'),
        reloadBtn: () => document.getElementById('reload')
    }

    Object.keys(elements)
        .map(key => elements[key]().style.display = 'block');

    await savePlayerScoreHandler(e, player);

    elements.saveBtn().addEventListener('click', e => savePlayerScoreHandler(e, player));
    elements.reloadBtn().addEventListener('click', e => reloadBulletsHandler(e, player));


    loadCanvas(player);
}

async function deletePlayerHandler(e) {
    const id = e.target.parentElement.id;
    await api.deletePlayer(id);
    e.target.parentElement.remove();
}

async function savePlayerScoreHandler(e, player) {
    await api.savePlayersScore(player);
}

function reloadBulletsHandler(e, player) {
    if (player.bullets === 6) { throw new Error('Your gun is full of bullets!') }
    player.money -= 60;
    player.bullets = 6;
}