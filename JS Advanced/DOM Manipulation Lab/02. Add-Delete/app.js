function addItem() {
    let inputText = document.getElementById('newText');
    let ul = document.getElementById('items');
    if (inputText === null || ul === null || inputText.value === '') {
        throw new Error('Elements that you are tring to get does not exist!');
    }

    let link = document.createElement('a');
    link.setAttribute('href', '#');
    link.innerHTML = '[Delete]';

    link.addEventListener('click', e => e.target.parentElement.remove());

    let li = document.createElement('li');
    li.textContent = inputText.value;
    li.appendChild(link);

    ul.appendChild(li);
    inputText.value = '';
}