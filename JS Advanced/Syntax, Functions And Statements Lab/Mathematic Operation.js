const operationMap = {
    "+": (a, b) => a + b,
    "-": (a, b) => a - b,
    "*": (a, b) => a * b,
    "/": (a, b) => a / b,
    "%": (a, b) => a % b,
    "**": (a, b) => a ** b,
}

function numbersOperations(firstNumber, secondNumber, operator){
    console.log(operationMap[operator](firstNumber, secondNumber));
    //console.log(eval(`${firstNumber} ${operator} ${secondNumber}`));
    //can be done with switch case as well !
}


numbersOperations(5, 3, "-");