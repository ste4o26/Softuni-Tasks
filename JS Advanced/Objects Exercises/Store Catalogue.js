function solve(input) {
    const catalogue = {};
    for (const line of input) {
        let [name, price] = line.split(' : ');
        price = Number(price);

        let letter = name.charAt(0);

        //kogato sazdavam vlojeni obekti proverqvam v glavniq obekt dali sushtestvuva takuv kliuch
        //i ako ne sushtestvuva go dobavqm kato nov obekt s edno properti i value v tozi sluchai
        if (!catalogue.hasOwnProperty(letter)) {
            catalogue[letter] = {};
        }

        const product = catalogue[letter];
        if (!product.hasOwnProperty(name)) {
            product[name] = price;
        }
    }

    //kogato iskam da sortiram obekti vzemam kliuchovete ili stoinostite i gi sortiram
    //sled koeto iteriram po sortiranite stoinostti i si vzemam konkretnoto properti ot obekta
    //kato polzvam za kliuch tekushtiq kliuch ot sortiranite!!!
    let sortedLeters = Object.keys(catalogue)
        .sort((f, s) => f.localeCompare(s));

    for (const letter of sortedLeters) {
        console.log(letter);
        let products = catalogue[letter];
        let sortedProducts = Object.keys(products)
            .sort((f, s) => f.localeCompare(s));
        for (const product of sortedProducts) {
            console.log(`  ${product}: ${products[product]}`);
        }
    }
}

solve(['Appricot : 20.4',
    'Fridge : 1500',
    'TV : 1499',
    'Deodorant : 10',
    'Boiler : 300',
    'Apple : 1.25',
    'Anti-Bug Spray : 15',
    'T-Shirt : 10']);