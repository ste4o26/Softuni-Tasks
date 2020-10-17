function solve() {
    const elements = {
        info: () => document.querySelector('#info .info'),
        depart: () => document.getElementById('depart'),
        arrive: () => document.getElementById('arrive')
    };


    let currentStopId;
    if (elements.info().textContent === 'Not Connected') { currentStopId = 'depot' }
    //`http://localhost:8000/schedule/{currentStopId}` => local server url just change it and it is suposed to work properly.
    const baseUrl = `https://judgetests.firebaseio.com/schedule/{currentStopId}.json`;

    function depart() {
        let url = baseUrl.replace('{currentStopId}', currentStopId);

        fetch(url)
            .then(response => {
                if (response.status >= 400) { throw new Error('ERROR') }
                return response.json();
            })
            .then(data => {
                if (data === null) { throw new Error(`Stop with id: ${currentStopId} does not exist!`) }
                elements.info().textContent = `Next stop ${data.name}`;
                togleDepartAndArrive();
            })
            .catch(err => {
                elements.info().textContent = err.message;
            });
    }

    function arrive() {
        let url = baseUrl.replace('{currentStopId}', currentStopId);

        fetch(url)
            .then(response => {
                if (response.status >= 400) { throw new Error('ERROR') }
                return response.json();
            })
            .then(data => {
                if (data === null) { throw new Error(`Stop with id: ${currentStopId} does not exist!`) }
                elements.info().textContent = `Arriving at ${data.name}`;
                currentStopId = data.next;
                togleDepartAndArrive();
            })
            .catch(err => {
                elements.info().textContent = err.message;
            });
    }

    function togleDepartAndArrive() {
        let depart = elements.depart();
        let arrive = elements.arrive();

        if (depart.disabled === true) {
            depart.disabled = false;
            arrive.disabled = true;
        } else {
            depart.disabled = true;
            arrive.disabled = false;
        }
    }

    return {
        depart,
        arrive
    };
}

let result = solve();