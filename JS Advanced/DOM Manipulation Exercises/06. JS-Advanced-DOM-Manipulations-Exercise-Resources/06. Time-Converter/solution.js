function attachEventsListeners() {
    const main = document.querySelector('main');
    const daysInput = document.querySelector('#days');
    const hoursInput = document.querySelector('#hours');
    const minutesInput = document.querySelector('#minutes');
    const secondsInput = document.querySelector('#seconds');

    const timeConverter = {
        daysBtn: convertFromDays,
        hoursBtn: convertFromHouors,
        minutesBtn: convertFromMinutes,
        secondsBtn: convertFromSeconds
    };

    main.addEventListener('click', e => {
        if (e.target === null || e.target.nodeName === 'input') {
            throw new Error('Something went wrong!');
        }

        let time = Number(e.target.previousElementSibling.value);
        timeConverter[e.target.id](time);
    });

    function convertFromDays(days) {
        secondsInput.value = days * 86400;
        minutesInput.value = days * 1440
        hoursInput.value = days * 24;
    }

    function convertFromHouors(hours) {
        secondsInput.value = hours * 3600;
        minutesInput.value = hours * 60;
        daysInput.value = hours / 24;
    }

    function convertFromMinutes(minutes) {
        secondsInput.value = minutes * 60;
        hoursInput.value = minutes / 60;
        daysInput.value = minutes / 1440;
    }

    function convertFromSeconds(seconds) {
        minutesInput.value = seconds / 60;
        hoursInput.value = seconds / 3600;
        daysInput.value = seconds / 86400;
    }
}