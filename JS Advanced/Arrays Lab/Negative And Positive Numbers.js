function solve(array) {
    const result = [];
    array.forEach(item => (item >= 0 ? result.push(item) : result.unshift(item)));
    return result.join('\n');
}

console.log(
    solve([7, -2, 8, 9] )
);

console.log(
    solve([3, -2, 0, -1])
);
