function solve(input) {
    const operationsMap = {
        chop: n => n / 2,
        dice: n => Math.sqrt(n),
        spice: n => n + 1,
        bake: n => n * 3,
        fillet: n => n * 0.8
    };

    const data = input.slice(1);
    data.reduce((number, operation) => {
        number = operationsMap[operation](number);
        console.log(number);
        return number;
    }, Number(input[0]))
}

console.log(
    solve(['32', 'chop', 'chop', 'chop', 'chop', 'chop'])
)