import { renderTemplate, toggleLoader } from './dom.js';
import { createFurniture, getTemplate, fetchAllFurnitures, fetchCurrentFurnitureDetails, deleteFurniture } from './data.js';

window.addEventListener('load', solve);

function solve() {
    const elements = {
        error: () => document.getElementById('errorBox'),
        info: () => document.getElementById('infoBox')
    };

    const app = Sammy('#container', function () {
        this.get('#/', loadAllFurnituresHandler);

        this.get('#/create-furniture', async (e) => {
            await renderTemplate('create-furniture', {}, this.swap.bind(this));
            document.getElementById('create-furniture-btn').addEventListener('click', createFurnitureHandler);

        });


        this.get('#/furniture-details/:id', loadFurnitureDetailsHandler);
        this.get('#/my-furnitures', loadMyFurnituresHandler);
    });
    app.run('#/');
}

async function loadAllFurnituresHandler(e) {
    let furnitures = await fetchAllFurnitures();
    Handlebars.registerPartial('furniture', await getTemplate('partials/furniture-item'));
    await renderTemplate('all-furnitures', { furnitures }, this.swap.bind(this));
}

async function createFurnitureHandler(e) {
    e.preventDefault();
    const furniture = {
        make: document.getElementById('new-make').value,
        model: document.getElementById('new-model').value,
        year: document.getElementById('new-year').value,
        description: document.getElementById('new-description').value,
        price: document.getElementById('new-price').value,
        imageUrl: document.getElementById('new-image').value,
        material: document.getElementById('new-material').value
    };

    validateFurniture(furniture);
    await createFurniture(furniture);
}

async function loadFurnitureDetailsHandler(e) {
    let id = e.params.id;
    const furnitureDetails = await fetchCurrentFurnitureDetails(id);
    await renderTemplate('furniture-details', furnitureDetails, this.swap.bind(this));
}

async function loadMyFurnituresHandler(e) {
    const furnitures = await fetchAllFurnitures();
    Handlebars.registerPartial('furniture', await getTemplate('partials/my-furniture-item'));
    await renderTemplate('my-furnitures', { furnitures }, this.swap.bind(this));
    document.getElementById('container').addEventListener('click', deleteFurnitureHandler);
}

//delete funkciqta ne bachka
// async function deleteFurnitureHandler(e) {
//     if (e.target.nodeName !== 'BUTTON' || e.target.className !== 'btn btn-danger') { return }
//     const id = e.params.id;
//     await deleteFurniture(id);
//     // loadMyFurnituresHandler(e);
// }


function validateFurniture(furniture) {
    if (furniture.make.length < 4 || furniture.model.length < 4) { throw new Error('Furniture make and model must be at least 4 symbols long!') }
    if (Number(furniture.year) < 1950 || Number(furniture.year) > 2050) { throw new Error('Furniture year must be between 1950 and 2050!') }
    if (furniture.description.length <= 10) { throw new Error('Description must be more than 10 symbols!') }
    if (Number(furniture.price) <= 0) { throw new Error('Price must be a positive number!') }
    if (furniture.imageUrl === undefined || furniture.imageUrl === null) { throw new TypeError('Image URL is required!') }
}