function subtract() {
    let divWrapper = document.querySelector('#wrapper');
    let divOutput = document.querySelector('#result');

    if (divWrapper === null || divOutput === null) {
        throw new Error('Somenthing went wrog!');
    }

    //judge raboti bez event listener
    divWrapper.addEventListener('change', e => {
        let [firstNumberInput, secondNumberInput] = document.querySelectorAll('input');
        if (firstNumberInput.value === '' || secondNumberInput === '') {
            throw new Error('You cannot subtract empty strings!');
        }
        divOutput.textContent = Number(firstNumberInput.value) - Number(secondNumberInput.value);
    });
}