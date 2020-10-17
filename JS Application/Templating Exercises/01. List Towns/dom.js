export function renderTowns(template) {
    const container = document.getElementById('root');
    if (container === null) { throw new TypeError('The element that you are looking for was not found!') }
    container.innerHTML = template;
    return container;
}