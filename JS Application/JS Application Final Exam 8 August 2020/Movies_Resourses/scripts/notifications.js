const notifications = document.getElementsByClassName('notifications');

export function displaySuccessMessage(message) {
    notifications[1].style.display = 'block';
    notifications[1].querySelector('#successBox').textContent = message;
    setTimeout(function () {
        notifications[1].style.display = 'none';
    }, 1000);
}


export function displayErrorMessage(message) {
    notifications[0].style.display = 'block';
    notifications[0].querySelector('#errorBox').textContent = message;
    setTimeout(function () {
        notifications[0].style.display = 'none';
    }, 1000);
}
