function lockedProfile() {
    const main = document.querySelector('main');

    main.addEventListener('click', e => {
        let isChecked = e.target.parentElement.children[2].checked;

        if (e.target === null) {
            throw new Error('Something went wrong!');
        }

        if (e.target.nodeName === 'BUTTON' && !isChecked) {
            const hiddenFields = e.target.previousElementSibling;

            if (e.target.textContent === 'Show more') {
                hiddenFields.style.display = 'block';
                e.target.textContent = 'Hide it';

            } else {
                hiddenFields.style.display = 'none';
                e.target.textContent = 'Show more';
            }
        }

        if (e.target.nodeName === 'INPUT') {
            e.target.checked;
        }
    });
}