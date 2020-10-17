import { fetchTemplates } from './data.js';

window.addEventListener('load', solve);

async function solve() {
    const [monkeyTemplate, allMonkeysTemplate] = await fetchTemplates();
    Handlebars.registerPartial('monkey', monkeyTemplate);

    const template = Handlebars.compile(allMonkeysTemplate);
    const monkeysContainer = document.querySelector('.monkeys');
    monkeysContainer.innerHTML = template({ monkeys });
    monkeysContainer.addEventListener('click', toggleDetailsHandler);
}

function toggleDetailsHandler(e) {
    if (e.target.nodeName !== 'BUTTON' || e.target.className !== 'showBtn') { return }
    const infoContainer = e.target.parentElement.querySelector('.info');

    infoContainer.style.display === 'none' ?
        infoContainer.style.display = 'block' :
        infoContainer.style.display = 'none';
}