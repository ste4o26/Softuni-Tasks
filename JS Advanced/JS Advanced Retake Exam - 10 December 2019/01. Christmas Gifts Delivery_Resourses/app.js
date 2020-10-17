function solution() {
    const addButton = document.querySelector('.container .card div button');

    addButton.addEventListener('click', addGiftToListHandler);

    function addGiftToListHandler(e) {
        const ul = document.querySelector('.container .card ul');
        const li = document.createElement('li');
        li.className = 'gift';
        li.textContent = this.previousElementSibling.value;

        const sendButton = document.createElement('button');
        sendButton.id = 'sendButton';
        sendButton.textContent = 'Send';
        sendButton.addEventListener('click', snedGiftHandler);
        li.appendChild(sendButton);

        const discardButton = document.createElement('button');
        discardButton.id = 'discardButton';
        discardButton.textContent = 'Discard';
        discardButton.addEventListener('click', discardGiftHandler);
        li.appendChild(discardButton);

        ul.appendChild(li);

        const items = ul.querySelectorAll('li');

        Array.from(items)
            .sort((f, s) => f.textContent.localeCompare(s.textContent))
            .map(item => ul.appendChild(item));

        this.previousElementSibling.value = ''; 
    }

    function snedGiftHandler(e) {
        const sendGiftUl = document.querySelectorAll('.container .card ul')[1];
        const li = document.createElement('li');
        li.className = 'gift';
        li.textContent = getGiftName(this);
        sendGiftUl.appendChild(li);

        this.parentElement.remove();
    }

    function discardGiftHandler(e) {
        let giftName = getGiftName(this);
        this.parentElement.remove();

        const discardedGiftUl = document.querySelectorAll('.container .card ul')[2];
        const li = document.createElement('li');
        li.className = 'gift';
        li.textContent = giftName;
        discardedGiftUl.appendChild(li);
    }

    function getGiftName(target) {
        let endingCharacterIndex = target.parentElement.innerHTML.indexOf('<');
        return target.parentElement.innerHTML.substring(0, endingCharacterIndex);
    }
}

