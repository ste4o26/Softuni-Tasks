function solve() {
    const addButton = document.querySelector('#container button');
    addButton.addEventListener('click', addNewPet);

    function addNewPet(e) {
        e.preventDefault();
        const inputs = document.querySelectorAll('#container input');
        let [name, age, kind, currentOwner] = [inputs[0].value, inputs[1].value, inputs[2].value, inputs[3].value];
        if (name.trim() === '' || age.trim() === '' || isNaN(Number(age)) || kind.trim() === '' || currentOwner.trim() === '') {
            throw new TypeError('All fields are not filled or age is not a number!');
        }
        age = Number(age);

        Array.from(inputs).map(input => input.value = '');

        const ul = document.querySelector('#adoption ul');
        const li = document.createElement('li');
        const p = document.createElement('p');

        const nameStrong = document.createElement('strong');
        nameStrong.textContent = name;
        p.appendChild(nameStrong);
        p.innerHTML = p.innerHTML.concat(' is a ');

        const ageStrong = document.createElement('strong');
        ageStrong.textContent = age;
        p.appendChild(ageStrong);
        p.innerHTML = p.innerHTML.concat(' year old ');

        const kindStrong = document.createElement('strong');
        kindStrong.textContent = kind;
        p.appendChild(kindStrong);
        li.appendChild(p);

        const span = document.createElement('span');
        span.textContent = `Owner: ${currentOwner}`;
        li.appendChild(span);

        const button = document.createElement('button');
        button.textContent = 'Contact with owner';
        button.addEventListener('click', changeOwner);
        li.appendChild(button);

        ul.appendChild(li);
    }

    function changeOwner(e) {
        const li = e.target.parentElement;
        li.querySelector('button').remove();

        const div = document.createElement('div');
        const input = document.createElement('input');
        input.placeholder = 'Enter your names';
        div.appendChild(input);

        const button = document.createElement('button');
        button.textContent = 'Yes! I take it!';
        button.addEventListener('click', takeThePet);
        div.appendChild(button);

        li.appendChild(div);
    }

    function takeThePet(e) {
        const ul = document.querySelector('#adopted ul');
        const li = e.target.parentElement.parentElement;

        e.target.parentElement.parentElement.remove();

        let newOwner = e.target.previousElementSibling.value;
        if (newOwner.trim() === '') { throw new TypeError('You should type your name in!!!') }


        li.querySelector('div').remove();
        li.querySelector('span').textContent = `New Owner: ${newOwner}`;

        const button = document.createElement('button');
        button.textContent = 'Checked';
        button.addEventListener('click', removeFromList);
        li.appendChild(button);

        ul.appendChild(li);
    }

    function removeFromList(e) {
        e.target.parentElement.remove();
    }
}

