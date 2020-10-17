function encodeAndDecodeMessages() {
    let [encodeBtn, decodeBtn] = document.querySelectorAll('button');
    let [encodeTextarea, decodeTextarea] = document.querySelectorAll('textarea');

    if (encodeBtn === null || decodeBtn === null || encodeTextarea === null || decodeTextarea === null) {
        throw new Error('Something went wrong!');
    }

    encodeBtn.addEventListener('click', e => {
        let encodedMessage = encodeMessage(encodeTextarea.value);
        encodeTextarea.value = '';
        decodeTextarea.value = encodedMessage;
    });


    decodeBtn.addEventListener('click', e => {
        let decodedMessage = decodeMessage(decodeTextarea.value);
        decodeTextarea.value = decodedMessage;
    });


    function encodeMessage(message) {
        return message
            .split('')
            .map(symbol => String.fromCharCode(symbol.charCodeAt(0) + 1))
            .join('');
    }

    function decodeMessage(message) {
        return message
            .split('')
            .map(symbol => String.fromCharCode(symbol.charCodeAt(0) - 1))
            .join('');
    }
}