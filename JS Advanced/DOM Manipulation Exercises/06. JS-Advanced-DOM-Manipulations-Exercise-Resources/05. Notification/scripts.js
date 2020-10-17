function notify(message) {
    const notificationDiv = document.querySelector('#notification');

    if (notificationDiv === null) {
        throw new Error('Something went wrong!');
    }

    notificationDiv.textContent = message;
    notificationDiv.style.display = 'block'
    setTimeout(() => notificationDiv.style.display = 'none', 2000);
}