function solve(input) {
    return [...input]
        .sort((f, s) => f.length - s.length || f.localeCompare(s))
        .join('\n')
        .trim();
}

console.log(
    solve(['alpha', 'beta', 'gamma'])
);