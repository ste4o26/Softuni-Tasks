import { getTemplate } from './data.js';

export async function renderTemplate(templatePath, context, swapFn) {
    const template = await getTemplate(templatePath);
    //document.getElementById('container').innerHTML = template({ context });
    //ekvivalentoto vav sammy js!!!
    swapFn(template(context));
}

export function toggleLoader() {
    const loader = document.getElementById('loadingBox');
    if (loader.style.display === 'none') {
        loader.style.display = 'block';
        return;
    }

    loader.style.display = 'none';
}
