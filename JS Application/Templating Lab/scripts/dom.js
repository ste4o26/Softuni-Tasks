export function renderTemplate(template) {
    const container = document.getElementById('app');
    if (container === null) { throw new TypeError('The element that you are looking for was not found!') }
    container.innerHTML = template;
    return container;
}

function toggleContactDetailsHandler(e) {
    if (e.target.nodeName !== 'BUTTON' || e.target.className !== 'detailsBtn') { return }
    const contactDetails = e.target.parentElement.querySelector('.details');
    if (contactDetails.style.display === 'none') { contactDetails.style.display = 'block' }
    else { contactDetails.style.display = 'none' }
}