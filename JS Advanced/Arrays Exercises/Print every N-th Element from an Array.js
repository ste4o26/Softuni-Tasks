function solve(input) {
    let n = Number(input.pop());
    return input
        .filter((_, index) => index % n === 0)
        .join('\n');
    // let n = Number(input.slice(input.length - 1));
    // input = input.slice(0, input.length - 1);
    // for (let i = 0; i < input.length; i += n) {
    //     console.log(input[i]);
    // }
}

console.log(
    solve(['5', '20', '31', '4', '20', '2'])
);