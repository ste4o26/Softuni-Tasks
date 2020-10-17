import * as dom from './domRenderer.js';
import * as api from "./httpMethodsApi.js";

window.addEventListener('load', solve);

function solve() {
    const elements = {
        loadBtn: () => document.getElementById('loadBooks'),
        createBtn: () => document.querySelector('form button'),
    }

    elements.loadBtn().addEventListener('click', displayAllBooksHandler);
    elements.createBtn().addEventListener('click', createBookHandler);
}

async function displayAllBooksHandler(e) {
    const elements = {
        table: () => document.getElementsByTagName('tbody')[0],
        loader: () => document.getElementById('loader')
    }

    elements.table().innerHTML = '';
    elements.loader().style.display = 'block';

    let data = await api.fetchAllBooks();
    if (data === undefined || data === null) { throw new TypeError('Not such data has been found!') }

    elements.loader().style.display = 'none';

    data.forEach(book => {
        const bookData = [book.title, book.author, book.isbn];
        const row = dom.renderTableRow(bookData);
        row.lastElementChild.children[0].addEventListener('click', updateBookHandler)
        row.lastElementChild.children[1].addEventListener('click', deleteBookHandler)
        row.id = book.objectId;
        elements.table().appendChild(row);
    });
}

async function createBookHandler(e) {
    e.preventDefault();
    const table = document.getElementsByTagName('tbody')[0];
    const inputs = {
        title: () => document.getElementById('title'),
        author: () => document.getElementById('author'),
        isbn: () => document.getElementById('isbn')
    }

    const isInvalidData = inputs.title().value.trim() === '' ||
        inputs.author().value.trim() === '' ||
        inputs.isbn().value.trim() === '';

    if (isInvalidData) { throw new Error('All fields are required!') } //or alert instead

    const book = {
        title: inputs.title().value,
        author: inputs.author().value,
        isbn: inputs.isbn().value
    }

    const newlyCreatedBook = await api.createBook(book);
    const row = dom.renderTableRow([newlyCreatedBook.title, newlyCreatedBook.author, newlyCreatedBook.isbn]);
    row.id = newlyCreatedBook.objectId;
    table.appendChild(row);
}



function updateBookHandler(e) {
    const row = dom.toggleEditor(e.target.parentElement.parentElement);
    row.lastElementChild.children[0].addEventListener('click', confirmUpdateHandler);
    row.lastElementChild.children[1].addEventListener('click', cancelUpdateHandler);
}

async function deleteBookHandler(e) {
    const bookId = e.target.parentElement.parentElement.id;
    await api.deleteBook(bookId);
    const tableRows = document.querySelectorAll('tbody > tr');
    const row = Array.from(tableRows)
        .find(row => row.id === bookId)
        .remove();
}

async function confirmUpdateHandler(e) {
    const bookId = e.target.parentElement.parentElement.id;
    const inputs = document.querySelectorAll('tbody input');
    const updatedBook = {
        title: inputs[0].value,
        author: inputs[1].value,
        isbn: inputs[2].value
    };

    const data = await api.updateBook(updatedBook, bookId);
    cancelUpdateHandler(e);
}

function cancelUpdateHandler(e) {
    const row = dom.toggleEditor(e.target.parentElement.parentElement);
    row.lastElementChild.children[0].addEventListener('click', updateBookHandler);
    row.lastElementChild.children[1].addEventListener('click', deleteBookHandler);
}
