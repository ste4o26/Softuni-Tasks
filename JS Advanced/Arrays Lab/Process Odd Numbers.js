function solve(array) {
    return array
        .filter((_, index) => index % 2 !== 0)
        .map(item => item *= 2)
        .reverse()
        .join(" ");
}


console.log(
    solve([10, 15, 20, 25])
);

console.log(
    solve([3, 0, 10, 4, 7, 3])
);