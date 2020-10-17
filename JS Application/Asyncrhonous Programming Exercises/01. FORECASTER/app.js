//using fetch API
function attachEvents() {
    const baseUrl = `https://judgetests.firebaseio.com/locations.json`;

    const elements = {
        location: () => document.getElementById('location'),
        submitBtn: () => document.getElementById('submit'),
        weatherSection: () => document.getElementById('forecast'),
        currentWeather: () => document.getElementById('current'),
        upcomingWeather: () => document.getElementById('upcoming')
    }

    const weatherEmotes = {
        'Sunny': '☀',
        'Partly sunny': '⛅',
        'Overcast': '☁',
        'Rain': '☂',
        'Degrees': '°'
    }

    elements.submitBtn().addEventListener('click', fetchWeather);

    function fetchWeather(e) {
        clearElements();

        fetch(baseUrl)
            .then(response => {
                if (response.status >= 400) { throw new Error(`Status code: ${response.status}\nStatus message: ${response.statusText}`) }
                return response.json();
            })
            .then(data => {
                let locationName = elements.location().value;
                let location = data.find(location => location.name === locationName);
                if (location === undefined) { throw new TypeError('The location that you are looking for is not found!') }

                fetchWeatherData('today', location.code);
                fetchWeatherData('upcoming', location.code);
            })
            .catch(err => displayErrorMessages(err));
    }

   

    function fetchWeatherData(time, code) {
        const currentWeatherUrl = `https://judgetests.firebaseio.com/forecast/${time}/${code}.json`;

        fetch(currentWeatherUrl)
            .then(response => {
                if (response.status >= 400) { throw new Error(`Status code: ${response.status}\nStatus message: ${response.statusText}`) }
                return response.json();
            })
            .then(data => displayWeather(time, data));
    }

    function displayWeather(time, data) {
        elements.weatherSection().style.display = 'block';
        const weatherFor = {
            today: (data) => displayCurrentWeather(data),
            upcoming: (data) => displayUpcomingWeather(data)
        }

        const forecastData = parseData(time, data);
        weatherFor[time](forecastData);
    }
   

    function displayCurrentWeather(forecastData) {
        const forecasts = document.createElement('div');
        forecasts.className = 'forecasts';
        elements.currentWeather().appendChild(forecasts);

        const conditionSymbol = createSpan('condition symbol', weatherEmotes[forecastData.weather]);
        forecasts.appendChild(conditionSymbol);

        const condition = createSpan('condition');
        forecasts.appendChild(condition);

        Object.keys(forecastData)
            .forEach(key => {
                const span = createSpan('forecast-data', forecastData[key]);
                condition.appendChild(span);
            });
    }

    function displayUpcomingWeather(forecastData) {
        const forecasts = document.createElement('div');
        forecasts.className = 'forecast-info';
        elements.upcomingWeather().appendChild(forecasts);

        forecastData.forEach(day => {
            const upcoming = createSpan('upcoming');
            forecasts.appendChild(upcoming);

            const conditionSymbol = createSpan('symbol', weatherEmotes[day.weather]);
            upcoming.appendChild(conditionSymbol);

            Object.keys(day)
                .forEach(key => {
                    const span = createSpan('forecast-data', day[key]);
                    upcoming.appendChild(span);
                })
        })
    }

    function parseData(time, data) {
        if (time === 'today') {
            return {
                name: data.name,
                degrees: `${data.forecast.low}${weatherEmotes.Degrees}/${data.forecast.high}${weatherEmotes.Degrees}`,
                weather: data.forecast.condition
            }
        }

        return data.forecast.reduce((acc, day) => {
            let dayData = {
                degrees: `${day.low}${weatherEmotes.Degrees}/${day.high}${weatherEmotes.Degrees}`,
                weather: day.condition
            }
            acc.push(dayData);
            return acc;
        }, []);
    }

    function clearElements() {
        elements.currentWeather().innerHTML = '';
        elements.upcomingWeather().innerHTML = '';
        const errorMessage = elements.weatherSection().getElementsByClassName('error-message')[0];
        if (errorMessage !== undefined) { errorMessage.remove() }
    }

    function createSpan(className, content) {
        const span = document.createElement('span');
        span.className = className;
        if (content === undefined || content.trim() === '') { return span }
        span.textContent = content;
        return span;
    }

    function displayErrorMessages(err) {
        const span = createSpan('error-message', err.message);
        elements.weatherSection().style.display = 'block';
        elements.weatherSection().style.textAlign = 'center';
        elements.weatherSection().appendChild(span);
    }
}

attachEvents();