window.addEventListener('load', e => addItem());

function addItem() {
    let button = document.getElementsByTagName('input')[2];
    let itemTextInput = document.querySelector('#newItemText');
    let itemValueInput = document.querySelector('#newItemValue');
    let select = document.querySelector('#menu');

    if (button == null || itemValueInput === null || itemTextInput === null || select === null) {
        throw new Error('Something went wrong!');
    }

    button.addEventListener('click', e => {
        let option = document.createElement('option');
        option.textContent = itemTextInput.value;
        option.value = itemValueInput.value;
        select.appendChild(option);

        itemTextInput.value = '';
        itemValueInput.value = '';
    });
};


//judge raboti s property to ot dolu zakacheno kum butona i bez event listener - ite!
//onclick="addItem()