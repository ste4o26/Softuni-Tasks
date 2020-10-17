function solve(data) {
    const town = {};

    data
        .filter((_, index) => index % 2 === 0)
        .map((key) => town[key] = 0);

    for (let i = 0; i < data.length - 1; i += 2) {
        let key = data[i];
        let value = data[i + 1];

        town[key] += Number(value);
    }

    return JSON.stringify(town);

}


console.log(
    solve(['Sofia', '20', 'Varna', '3', 'Sofia', '5', 'Varna', '4'])
)

console.log(
    solve(['Sofia', '20', 'Varna', '3', 'sofia', '5', 'varna', '4'])
);