function solve(input) {

    let result = `<table>\n`
    result += input.map(item => JSON.parse(item))
        .reduce((accumolator, obj) => {
            accumolator += `    <tr>\n`;

            accumolator += Object.values(obj)
                .reduce((acc, item) => acc + `      <td>${item}</td>\n`, ``);

            accumolator += `    </tr>\n`;
            return accumolator;
        }, ``);

    result += `</table>`
    return result;
}

console.log(
    solve(['{"name":"Pesho","position":"Promenliva","salary":100000}',
        '{"name":"Teo","position":"Lecturer","salary":1000}',
        '{"name":"Georgi","position":"Lecturer","salary":1000}'])
);