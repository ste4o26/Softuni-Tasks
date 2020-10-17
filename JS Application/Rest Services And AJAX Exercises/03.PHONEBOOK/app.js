//made with firebase api
function attachEvents() {
    //'http://localhost:8000/phonebook/{id}' => local server url just change it and it is suposed to work properly.
    const baseUrl = `https://phonebook-nakov.firebaseio.com/phonebook/{id}.json`;

    const elements = {
        phonebook: () => document.getElementById('phonebook'),
        load: () => document.getElementById('btnLoad'),
        create: () => document.getElementById('btnCreate'),
    }

    elements.create().addEventListener('click', createContact);
    elements.load().addEventListener('click', fetchAllContacts);
    elements.phonebook().addEventListener('click', deleteContact);

    function createContact(e) {
        let url = baseUrl.replace('{id}', '');

        const inputs = {
            person: () => document.getElementById('person'),
            phone: () => document.getElementById('phone')
        }

        fetch(url, {
            method: 'POST',
            body: JSON.stringify(
                {
                    person: inputs.person().value,
                    phone: inputs.phone().value
                }
            ),
            headers: {
                'Content-Type': 'application/json',
            }
        });

        inputs.person().value = '';
        inputs.phone().value = '';
    }

    function fetchAllContacts(e) {
        let url = baseUrl.replace('{id}', '');
        elements.phonebook().innerHTML = '';

        fetch(url)
            .then(response => {
                if (response.status >= 400) { throw new Error(`Invalid data or request\nStatus code: ${response.status}\nMessage: ${response.statusText}`) }
                return response.json();
            })
            .then(data => {
                if (data === undefined || data === null) { throw new Error('No contacts are found!') }

                Object.keys(data)
                    .map(contactId => {
                        const li = document.createElement('li');
                        li.id = contactId;
                        li.textContent = `${data[contactId].person}: ${data[contactId].phone}`;

                        const button = document.createElement('button');
                        button.className = 'btnDelete';
                        button.textContent = 'Delete';
                        li.appendChild(button);
                        elements.phonebook().appendChild(li);
                    });
            })
            .catch(err => console.error(err.message))
    }

    function deleteContact(e) {
        if (e.target.nodeName !== 'BUTTON' && e.target.className !== 'btnDelete') {
            throw new Error('You should click on delete button to delete a contact from the phonebook!');
        }

        let url = baseUrl.replace('{id}', e.target.parentElement.id);
        fetch(url, {
            method: 'DELETE',
            headers: { 'Content-Type': 'application/json' }
        });

        e.target.parentElement.remove();
    }
}

attachEvents();