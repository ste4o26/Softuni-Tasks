function solve(data) {
    return JSON.stringify(data.map(item => item.split(/ -> | : /g))
        .reduce((accumolator, tokens) => {
            const product = {};
            product[tokens[1]] = Number(tokens[2]) * Number(tokens[3]);
            if (accumolator[tokens[0]] === undefined) {
                accumolator[tokens[0]] = [];
            }
            accumolator[tokens[0]].push(product);
            return accumolator;
        }, {}));

    //judge raboti s tova !!!
    // for (let [key, val] of Object.entries(towns)) {
    //     console.log(`Town - ${key}`);
    //     for (const product of val) {
    //         for (let [k, v] of Object.entries(product)) {
    //             console.log(`$$$${k} : ${v}`)
    //         }
    //     }
    // }
}


console.log(
    solve(['Sofia -> Laptops HP -> 200 : 2000',
        'Sofia -> Raspberry -> 200000 : 1500',
        'Sofia -> Audi Q7 -> 200 : 100000',
        'Montana -> Portokals -> 200000 : 1',
        'Montana -> Qgodas -> 20000 : 0.2',
        'Montana -> Chereshas -> 1000 : 0.3'])
);