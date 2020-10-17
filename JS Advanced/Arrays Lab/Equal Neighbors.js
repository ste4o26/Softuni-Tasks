function solve(matrix) {
    let sum = 0;

    for (let row = 0; row < matrix.length - 1; row++) {
        let first = matrix[row];
        let second = matrix[row + 1];

        sum += first
            .filter((item, index) => item === second[index])
            .length;
    }

    matrix.forEach(array => {
        sum += array
            .filter((item, index, cuurrentArray) => item === cuurrentArray[index + 1]).length
    });

    return sum;
}


console.log(
    solve([['2', '3', '4', '7', '0'],
    ['4', '0', '5', '3', '4'],
    ['2', '3', '5', '4', '2'],
    ['9', '8', '7', '5', '4']])
);

console.log(
    solve([['test', 'yes', 'yo', 'ho'],
    ['well', 'done', 'yo', '6'],
    ['not', 'done', 'yet', '5']])
);

console.log(
    solve([[2, 2, 5, 7, 4],
    [4, 0, 5, 3, 4],
    [2, 5, 5, 4, 2]])
);