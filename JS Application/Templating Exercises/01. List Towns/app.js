import { fetchTownsData, fetchTemplates } from './data.js';
import { renderTowns } from './dom.js';

window.addEventListener('load', solve);

function solve() {
    document.getElementById('btnLoadTowns').addEventListener('click', dipslayTownsHandler);
}

async function dipslayTownsHandler(e) {
    e.preventDefault();

    let towns;
    try {
        towns = fetchTownsData();
    } catch (err) {
        document.getElementById('root').textContent = err.message;
        return;
    }

    const [townTemplate, allTownsTemplate] = await fetchTemplates();
    Handlebars.registerPartial('town', townTemplate);
    const template = Handlebars.compile(allTownsTemplate);

    renderTowns(template({ towns }));
}

