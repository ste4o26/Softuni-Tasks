function solve(data, startIndex, endIndex) {
    if (!Array.isArray(data)) return NaN;
    if (startIndex < 0) startIndex = 0;
    if (endIndex >= data.length) endIndex = data.length - 1;

    return Number(data
        .slice(startIndex, endIndex + 1)
        .reduce((a, b) => a + Number(b), 0)
        .toFixed(1));
}

console.log(
    solve('text', 0, 2)
);