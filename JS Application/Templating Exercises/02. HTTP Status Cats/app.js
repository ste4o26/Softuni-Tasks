import { fetchTemplates } from './data.js';

window.addEventListener('load', solve);

async function solve() {
    const [catTemplate, allCatsTemplate] = await fetchTemplates();

    Handlebars.registerPartial('cat', catTemplate);
    const template = Handlebars.compile(allCatsTemplate);

    const catsContainer = document.getElementById('allCats');
    catsContainer.addEventListener('click', toggleDetailsHandler);

    catsContainer.innerHTML = template({ cats });
}

function toggleDetailsHandler(e) {
    if (e.target.nodeName !== 'BUTTON' || e.target.className !== 'showBtn') { return }
    const container = e.target.parentElement.querySelector('.status');

    if (container.style.display === 'block') {
        container.style.display = 'none';
        e.target.textContent = 'Show status code'
    } else {
        container.style.display = 'block';
        e.target.textContent = 'Hide status code'
    }
}
