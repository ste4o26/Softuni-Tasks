function attachEvents() {
    const elements = {
        catches: () => document.getElementById('catches'),
        loadBtn: () => document.getElementsByClassName('load')[0],
        addBtn: () => document.getElementsByClassName('add')[0]
    }

    const baseUrl = `https://fisher-game.firebaseio.com/catches/{catchId}.json`;

    elements.loadBtn().addEventListener('click', fetchAllCatchesHandler);
    elements.addBtn().addEventListener('click', createNewCatchHandler);
    elements.catches().addEventListener('click', function (e) {
        if (e.target.nodeName === 'BUTTON' && e.target.className === 'delete') { deleteCatchHandler(e) }
        if (e.target.nodeName === 'BUTTON' && e.target.className === 'update') { updateCatchHandler(e) }
    });

    function updateCatchHandler(e) {
        let result;
        let url = baseUrl.replace('{catchId}', e.target.parentElement.id);
        const [angler, weight, species, location, bait, captureTime] = e.target.parentElement.querySelectorAll('input');

        fetch(url, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                angler: angler.value,
                weight: weight.value,
                species: species.value,
                location: location.value,
                bait: bait.value,
                captureTime: captureTime.value
            })
        })
            .then(response => response.json())
            .then(data => result = data);
        return result;
    }

    function deleteCatchHandler(e) {
        let result;
        let url = baseUrl.replace('{catchId}', e.target.parentElement.id);
        fetch(url)
            .then(response => response.json())
            .then(data => result = data);

        fetch(url, {
            method: 'DELETE',
            headers: { 'Content-Type': 'application/json' }
        });

        document.getElementById(e.target.parentElement.id).remove();
        return result;
    }

    function createNewCatchHandler(e) {
        let result;
        let url = baseUrl.replace('{catchId}', '');
        const [angler, weight, species, location, bait, captureTime] = document.querySelectorAll('aside #addForm input');
        fetch(url, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                angler: angler.value,
                weight: weight.value,
                species: species.value,
                location: location.value,
                bait: bait.value,
                captureTime: captureTime.value
            })
        })
            .then(response => response.json())
            .then(data => result = data);

        return result;
    }

    function fetchAllCatchesHandler(e) {
        let result;
        elements.catches().innerHTML = '';
        let url = baseUrl.replace('{catchId}', '');
        fetch(url)
            .then(response => {
                if (response.status >= 400) { throw new Error(`Status code: ${response.status}\nMessage: ${response.statusText}`) }
                return response.json();
            })
            .then(data => {
                if (data === undefined || data === null) { throw new TypeError('You should add some data to the database first!') }

                const contentsMap = {
                    angler: 'Angler',
                    weight: 'Weight',
                    species: 'Species',
                    location: 'Location',
                    bait: 'Bait ',
                    captureTime: 'Capture Time'
                }

                Object.keys(data)
                    .forEach(id => {
                        const catched = document.createElement('div');
                        catched.className = 'catch';
                        catched.id = id;

                        Object.keys(data[id])
                            .forEach(property => {
                                const anglerLabel = createElement('label', contentsMap[property], undefined, undefined);
                                catched.appendChild(anglerLabel);

                                const anglerInput = createElement('input', data[id][property], property, 'text');
                                catched.appendChild(anglerInput);

                                catched.appendChild(document.createElement('hr'));
                            });

                        const updateBtn = createElement('button', 'Update', 'update', undefined);
                        catched.appendChild(updateBtn);

                        const deleteBtn = createElement('button', 'Delete', 'delete', undefined);
                        catched.appendChild(deleteBtn);

                        elements.catches().appendChild(catched);
                    });

                result = data;
            })
            .catch(err => console.log(err.message));

        return result;
    }


    function createElement(elementType, content, className, type) {
        const element = document.createElement(elementType);
        const elementsMap = {
            input: () => {
                element.type = type;
                element.className = className;
                element.value = content;
            },
            label: () => element.textContent = content,
            button: () => {
                element.className = className;
                element.textContent = content;
            }
        }

        if (elementType === 'hr') { return element }
        elementsMap[elementType]();
        return element;
    }
}



attachEvents();