export function renderPlayer(player) {
    const palyerContainer = document.createElement('div');
    palyerContainer.className = 'player';

    const paragraphs = [];
    for (let i = 0; i < 3; i++) {
        const p = document.createElement('p');
        paragraphs.push(p);
        palyerContainer.appendChild(p);
    }

    paragraphs[0].textContent = `Name: ${player.name}`;
    paragraphs[1].textContent = `Money: ${player.money}`;
    paragraphs[2].textContent = `Bullets: ${player.bullets}`;

    const playBtn = document.createElement('button');
    playBtn.className = 'play';
    playBtn.textContent = 'Play';
    palyerContainer.appendChild(playBtn);

    const deleteBtn = document.createElement('button');
    deleteBtn.className = 'delete';
    deleteBtn.textContent = 'Delete';
    palyerContainer.appendChild(deleteBtn);

    return palyerContainer;
}