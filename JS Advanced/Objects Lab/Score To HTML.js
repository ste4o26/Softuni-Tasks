function solve(data) {
    let result = '<table>\n   <tr><th>name</th><th>score</th></tr>\n'
    const people = JSON.parse(data);
    result = people.reduce((accumolator, item) => {
        accumolator += `   <tr><td>${escapeHtml(item.name)}</td><td>${item.score}</td></tr>\n`;
        return accumolator;
    }, result);

    result += '</table>';

    return result;
}

function escapeHtml(unsafe) {
    return unsafe
        .replace(/&/g, "&amp;")
        .replace(/</g, "&lt;")
        .replace(/>/g, "&gt;")
        .replace(/"/g, "&quot;")
        .replace(/'/g, "&#39;");
}


console.log(
    solve(['[{"name":"Pesho","score":479}, {"name":"Gosho","score":205}]'])
);


console.log(
    solve(['[{"name":"Pesho & Kiro","score":479}, {"name":"Gosho, Maria & Viki","score":205}]'])
)