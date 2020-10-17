const appId = '1C7B7EFD-E786-40F0-FF34-2B058351BD00';
const apiKey = '7688E6B3-201F-4DE9-B1D3-6A9F47223EBB';

function host(endpoint) { return `https://api.backendless.com/${appId}/${apiKey}/data/${endpoint}` }

function throwErrorIfBadRequest(response) {
    if (response.status >= 400) { throw new Error(`Status code: ${response.status}  -  Message: ${response.statusText}`) }
}

export async function fetchAllBooks() {
    const response = await fetch(host('Books'))
    throwErrorIfBadRequest(response)
    const data = await response.json();
    return data;
}

export async function createBook(book) {
    const response = await fetch(host('Books'), {
        method: 'POST',
        body: JSON.stringify(book),
        headers: { 'Content-Type': 'application/json' }
    });

    throwErrorIfBadRequest(response)
    const data = await response.json();
    return data;
}

export async function updateBook(book, bookId) {
    const response = await fetch(host(`Books/${bookId}`), {
        method: 'PUT',
        body: JSON.stringify(book),
        headers: { 'Content-Type': 'application/json' }
    });
    throwErrorIfBadRequest(response);
    const data = await response.json();
    return data;
}

export async function deleteBook(bookId) {
    const response = await fetch(host(`Books/${bookId}`), { method: 'DELETE' });
    throwErrorIfBadRequest(response);
    const data = await response.json();
    return data;
}

