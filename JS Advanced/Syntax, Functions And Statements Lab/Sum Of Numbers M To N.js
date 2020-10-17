function solve(from, to){
    //can be done with parseFloat function as well!
    let firstNumber = Number(from);
    let secondNumber = Number(to);

    let sum = 0;
    for (let i = firstNumber; i <= secondNumber; i++) {
        sum += i;
    }

    return sum;
}

solve('1', '5');