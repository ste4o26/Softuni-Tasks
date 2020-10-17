function solve(matrix) {
    let mainDiagonal = 0;
    let secondaryDiagonal = 0;

    matrix.forEach((array, index) => {
        mainDiagonal += array[index];
        secondaryDiagonal += array[(array.length - 1) - index];
    })

    return mainDiagonal + ' ' + secondaryDiagonal;
}


console.log(
    solve(
        [
            [3, 5, 17],
            [-1, 7, 14],
            [1, -8, 89]
        ]
    )
);

console.log(
    solve(
        [
            [20, 40],
            [10, 60]
        ]
    )
);
