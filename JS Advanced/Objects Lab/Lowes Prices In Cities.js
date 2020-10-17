function solve(input) {

    return JSON.stringify(input
        .map(item => item.split(/ \| /))
        .reduce((accumolator, data) => {
            const product = {};
            product[data[1]] = Number(data[2]);
            product.town = data[0];

            if (!isExistingProductWithLowerPrice(data[1], accumolator, Number(data[2]))) {
                accumolator.push(product);
            }

            return accumolator;
        }, []));


    //judge raboti s tova !
    // for (const item of products) {
    //     let output = '';
    //     let count = 0;
    //     for (const key in item) {
    //         if (count % 2 == 0) {
    //             output += `${key} -> ${item[key]} `;
    //         } else {
    //             output += `(${item[key]})`
    //         }
    //         count++;
    //     }
    //     console.log(output);
    // }
}

function isExistingProductWithLowerPrice(name, products, price) {
    for (const item of products) {
        if (item[name] !== undefined) {
            if (item[name] < price) {
                return true;
            }
        }
    }

    return false;
}


console.log(
    solve(['Sample Town | Sample Product | 1000',
        'Sample Town | Orange | 2',
        'Sample Town | Peach | 1',
        'Sofia | Orange | 3',
        'Sofia | Peach | 2',
        'New York | Sample Product | 1000.1',
        'New York | Burger | 10'])
);