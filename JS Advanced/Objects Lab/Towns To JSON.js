function solve(data) {
    const keys = deserializeStringToArray(data[0]);

    data = data.slice(1);
    const values = [];

    return data
        .map(item => deserializeStringToArray(item))
        .map(values => values.reduce((accumolator, value, i) => {
                accumolator[keys[i]] = value;
                return accumolator;
            }, {})
        );
}


function deserializeStringToArray(str) {
    const isNotEmptyString = item => item !== '';
    const trimString = item => item.trim();
    const parseIfNumber = item => !isNaN(Number(item)) ? Number(Number(item).toFixed(2)) : item;

    return str
        .split('|')
        .filter(isNotEmptyString)
        .map(trimString)
        .map(parseIfNumber);
}

console.log(
    solve([
        '| Town | Latitude | Longitude |',
        '| Sofia | 42.696552 | 23.32601 |',
        '| Beijing | 39.913818 | 116.363625 |'
    ])
);