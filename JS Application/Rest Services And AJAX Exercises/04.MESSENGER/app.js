function attachEvents() {
    //'http://localhost:8000/messenger' => local server url just change it and it is suposed to work properly.
    const baseUrl = `https://rest-messanger.firebaseio.com/messanger.json`;
    const elements = {
        send: () => document.getElementById('submit'),
        refresh: () => document.getElementById('refresh'),
        messages: () => document.getElementById('messages')
    };

    elements.send().addEventListener('click', sendMessage);
    elements.refresh().addEventListener('click', displayAllMessages);

    function sendMessage(e) {
        const inputs = {
            author: () => document.getElementById('author'),
            content: () => document.getElementById('content')
        };

        if (inputs.author().value.trim() === '' || inputs.author().value === '') { throw new Error('Fill the required fields!') }

        fetch(baseUrl, {
            method: 'POST',
            body: JSON.stringify(
                {
                    author: inputs.author().value,
                    content: inputs.content().value,
                }
            ),
            headers: { 'Content-Type': 'application/json' }
        });

        inputs.author().value = '';
        inputs.content().value = '';
    }

    function displayAllMessages(e) {
        fetch(baseUrl)
            .then(response => {
                if (response.status >= 400) { throw new Error(`Status code: ${response.status}\nStatus message:${response.statusText}`) }
                return response.json()
            })
            .then(data => {
                if (data === null || data === undefined) { throw new TypeError('You should first enter some data!') }
                elements.messages().textContent = Object.keys(data)
                    .reduce((acc, messageId) => acc.concat(`${data[messageId].author}: ${data[messageId].content}\n`), '')
                    .trim();
            })
            .catch(err => alert(err.message));
    }
}

attachEvents();