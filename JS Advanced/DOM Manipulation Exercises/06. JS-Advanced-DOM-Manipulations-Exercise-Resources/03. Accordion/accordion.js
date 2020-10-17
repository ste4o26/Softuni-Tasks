function toggle() {
    let button = document.querySelector('.button');
    let textDiv = document.querySelector('#extra');

    if (button === null || textDiv === null) {
        throw new Error('Something went wrong!');
    }

    if (button.textContent === 'More') {
        textDiv.style.display = 'block';
        button.textContent = 'Less';

    } else {
        textDiv.style.display = 'none';
        button.textContent = 'More';
    }
}

//can be done with event listener and it would be better to do so!