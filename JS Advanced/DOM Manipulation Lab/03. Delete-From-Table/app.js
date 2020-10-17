function deleteByEmail() {
    let input = document.getElementsByName('email')[0];
    let outputDiv = document.getElementById('result');

    if (input === null || outputDiv === null) {
        throw new Error('Elements which you are tring to access may not exist!');
    }

    let emailToDelete = input.value;
    let row = fetchRowByEmail(emailToDelete);

    if (row === null) {
        //outputDiv.textContent = 'Not found.'
        throw new Error('Not found.');
    }

    row.remove();
    outputDiv.textContent = 'Deleted.'
}

function fetchRowByEmail(email) {
    let table = document.getElementById('customers');
    if (table === null) {
        throw new Error('The elelment which you are tring to access may not exist!');
    }

    let currentRow = table.lastElementChild.firstElementChild;
    while (currentRow !== null) {
        if (currentRow.lastElementChild.textContent === email) {
            return currentRow;
        }

        currentRow = currentRow.nextElementSibling;
    }
    
    return null;
}