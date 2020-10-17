import { contacts } from '../data/contacts.js';
import { renderTemplate, toggleContactDetailsHandler } from './dom.js';

window.addEventListener('load', solve);

async function solve() {
    const data = await fetchTemplates();
    const [contactCardTemplate, allContactsTemplate] = data

    //here i am passing the name that i use in my partial template! And the second argument is the template itself
    Handlebars.registerPartial('contactCard', contactCardTemplate);
    const template = Handlebars.compile(allContactsTemplate);
    const contactsElement = renderTemplate(template({ contacts }));

    contactsElement.addEventListener('click', toggleContactDetailsHandler);
}


async function fetchTemplates() {
    const response = await Promise.all([
        await fetch('./templates/contact-card-template.hbs'),
        await fetch('./templates/all-contacts-template.hbs')
    ]);

    const data = await Promise.all(response.map(res => res.text()));
    return data;
}