function getInfo() {
    const validIds = ['1287', '1308', '1327', '2334'];
    const elements = {
        busStopId: () => document.getElementById('stopId').value,
        busStopName: () => document.getElementById('stopName'),
        buses: () => document.getElementById('buses')
    };

    let stopId = elements.busStopId();
    //`http://localhost:8000/businfo/${stopId}` => local server url just change it and it is suposed to work properly.
    const url = `https://judgetests.firebaseio.com/businfo/${stopId}.json`;

    elements.busStopName().textContent = '';
    elements.buses().innerHTML = '';

    fetch(url)
        .then(response => {
            if (!validIds.includes(stopId)) {
                // throw new Error('ERROR');
                throw new Error(`NO BUS STOPS WITH ID: ${stopId}`);
            }

            return response.json();
        })
        .then(data => {
            elements.busStopName().textContent = data.name;

            let buses = data.buses;
            const arivalBusses = elements.buses();
            Object.keys(buses).forEach(busKey => {
                let busData = document.createElement('li');
                busData.textContent = `Bus ${busKey} arrives in ${buses[busKey]}`;
                arivalBusses.appendChild(busData);
            });
        })
        .catch(err => elements.busStopName().textContent = err.message);
}