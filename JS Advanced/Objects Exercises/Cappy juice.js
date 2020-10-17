function solve2(input) {
    const juices = {};
    const bottles = {};
    for (const line of input) {
        let [type, quantity] = line.split(' => ');
        if (!juices.hasOwnProperty(type)) {
            juices[type] = 0;
        }

        juices[type] += Number(quantity);

        let bottlesCount = Math.trunc(juices[type] / 1000);
        if (bottlesCount >= 1) {
            bottles[type] = bottlesCount;
        }
    }

    for (const key in bottles) {
        if (bottles.hasOwnProperty(key)){
            console.log(`${key} => ${bottles[key]}`);
        }
    }
}

console.log(
    solve2(['Orange => 2000',
        'Peach => 1432',
        'Banana => 450',
        'Peach => 600',
        'Strawberry => 549'])
);