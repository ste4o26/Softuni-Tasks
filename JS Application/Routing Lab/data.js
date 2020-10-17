const apiKey = 'AFEBA677-E5B5-488C-B6D4-2AC30BB9FD47';
const appId = 'FF019AF7-2D7D-1A38-FFF4-18D823B75800';

function getUrl(endPoint) {
    return `https://api.backendless.com/${appId}/${apiKey}/data/${endPoint}`;
}

function getTemplateUrl(templatePath) {
    return `./templates/${templatePath}.hbs`;
}

export async function getTemplate(templatePath) {
    const url = getTemplateUrl(templatePath);
    const response = await fetch(url);

    let templateString;
    try {
        templateString = await response.text();
    } catch (error) {
        console.error(error);
    }

    return Handlebars.compile(templateString);
}

export async function createFurniture(furniture) {
    const url = getUrl('furniture');
    const response = await fetch(url, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(furniture)
    });

    throwErrorIfBadRequest(response);

    const data = await response.json();
    return data;
}

export async function fetchAllFurnitures() {
    const url = getUrl('furniture');
    const response = await fetch(url);
    throwErrorIfBadRequest(response);
    const data = await response.json();
    return data;
}

export async function fetchCurrentFurnitureDetails(objectId) {
    const url = getUrl(`furniture/${objectId}`);
    const response = await fetch(url);
    throwErrorIfBadRequest(response);
    const data = response.json();
    return data;
}

export async function deleteFurniture(objectId) {
    const url = getUrl(`furniture/${objectId}`);
    const response = await fetch(url, { method: 'DELETE' });
    throwErrorIfBadRequest(response);
    const data = await response.json();
    return data;
}

function throwErrorIfBadRequest(response) {
    if (response.status >= 400) { throw new Error(`Status code:${response.status}  -  Status message:${response.statusText}`) }
}