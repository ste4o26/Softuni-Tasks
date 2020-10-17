function solve(input) {
    let rowsSums = input.map(array => {
        return array.reduce((a, b) => a + b, 0);
    });

    let colsSums = getCollumnsSums(input);
    return rowsSums.every(a => a === colsSums[0]) && colsSums.every(a => a === rowsSums[0]);
}

//obikalq po matricata i vzema elementite ot kolonite kato gi podava kato nov masiv 
//na vtoriq reduce koito sumira kolonite i nakraq vrushta masiv ot sumite na otdelnite koloni
function getCollumnsSums(matrix) {
    return matrix
        .reduce((accumolator, _, index) => {
            let sum = input
                .map(array => array[index])
                .reduce((a, b) => a + b, 0);
            accumolator.push(sum);
            return accumolator;
        }, []);
}



console.log(
    solve([[4, 5, 6],
    [6, 5, 4],
    [5, 5, 5]])
);

console.log(
    solve([[11, 32, 45],
    [21, 0, 1],
    [21, 1, 1]])
);

console.log(
    solve([[1, 0, 0],
    [0, 0, 1],
    [0, 1, 0]])
);