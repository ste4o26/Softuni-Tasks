function stopwatch() {
    let startButton = document.getElementById('startBtn');
    let stopButton = document.getElementById('stopBtn');
    let div = document.getElementById('time');

    if (startButton === null || stopButton === null || div === null) {
        throw new Error('Something went wrong!');
    }

    let interval;

    startButton
        .addEventListener('click', e => start(e));//e => start(e, interval, stopButton, div)

    stopButton
        .addEventListener('click', e => stop(e));//e => stop(e, interval, startButton)

    function start(e) {
        div.textContent = '00:00'
        e.target.disabled = true;
        stopButton.disabled = false;
        let totalSeconds = 0;

        interval = setInterval(() => {
            totalSeconds++;
            let date = new Date(null, null, null, null, null, totalSeconds);
            console.log(date);
            div.textContent = date.toString().slice(19, 24);
        }, 1000);
    }

    function stop(e) {
        clearInterval(interval);
        e.target.disabled = true;
        startButton.disabled = false;
    }
}
