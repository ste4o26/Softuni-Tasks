function solve(data) {
    function escapeHtml(unsafe) {
        return unsafe.toString()
            .replace(/&/g, "&amp;")
            .replace(/</g, "&lt;")
            .replace(/>/g, "&gt;")
            .replace(/"/g, "&quot;")
            .replace(/'/g, "&#39;");
    }

    const products = JSON.parse(data);
    let result = `<table>\n   <tr>`

    const keys = Object.keys(products[0]);
    result = keys.reduce((accumolator, key) => {
        accumolator += `<th>${escapeHtml(key)}</th>`;
        return accumolator;
    }, result)

    result += `</tr>\n`;


    for (const product of products) {
        result += `   <tr>`;
        for (const key of keys) {
            result += `<td>${escapeHtml(product[key])}</td>`;
        }
        result += `</tr>\n`;
    }

    return result += `</table>`;
}


console.log(
    solve(['[{"Name":"Tomatoes & Chips","Price":2.35},{"Name":"J&B Chocolate","Price":0.96}]'])
);

console.log(
    solve(['[{ "Name": "Pesho <div>-a", "Age": 20, "City": "Sofia" }, { "Name": "Gosho", "Age": 18, "City": "Plovdiv" }, { "Name": "Angel", "Age": 18, "City": "Veliko Tarnovo" }]'])
);