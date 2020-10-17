function solve() {
    const dropdown = document.querySelector('#dropdown-ul');
    const button = document.querySelector('#dropdown');
    const div = document.querySelector('#box');

    if (dropdown === null || button === null || div === null) {
        throw new TypeError('Something went wrong!');
    }

    button.addEventListener('click', function (e) {
        if (dropdown.style.display === 'block') {
            div.style.background = 'black';
            div.style.color = 'white';
            dropdown.style.display = 'none';

        } else {
            dropdown.style.display = 'block'
            dropdown.addEventListener('click', function (e) {
                div.style.color = 'black';
                div.style.background = e.target.textContent;
            });
        }
    });
}