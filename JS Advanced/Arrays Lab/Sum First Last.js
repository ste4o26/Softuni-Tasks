function solve(array){
    let firstNumber = Number(array[0]);
    let secondNumber = Number(array[array.length - 1]);
    return firstNumber + secondNumber;
}


console.log(
    solve(['20', '30', '40']),
    solve(['5', '10'])
);