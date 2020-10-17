let inputButton = document.getElementsByTagName('input')[1];
if (inputButton === null) {
    throw new Error('Ypu are tring to get elements which does not exists!');
}

inputButton.addEventListener('click', e => handler(e));

function handler(event) {
    console.log(event.target);
    let inputText = event.target.previousElementSibling;
    let ul = document.getElementById('items');
    let li = document.createElement('li');

    if (inputText === null || ul === null || inputText.value === '') {
        throw new Error('Something went wrong!');
    }

    li.textContent = inputText.value;
    ul.appendChild(li);
    inputText.value = '';
    event.stopPropagation();
}

//v judge minava tova kato na butona trqbva da mu napisha onClick event v samiq element!!!
// function addItem() {
//     // let inputText = document.getElementById('newItemText');
//     // let ul = document.getElementById('items');

//     // if (inputText === null || ul === null) {
//     //     throw new Error('Ypu are tring to get elements which does not exists!');
//     // }

//     // if (inputText.value === '') {
//     //     alert('You cant add empty element into the list!');
//     //     throw new Error('Tring to insert empty element into the list!');
//     // }

//     // let li = document.createElement('li');
//     // li.textContent = inputText.value;
//     // ul.appendChild(li);
//     // inputText.value = '';
// }