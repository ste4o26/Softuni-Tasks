function solve(data) {
    return JSON.stringify(data.reduce((accumolator, item) => {
        const array = item.split(/ <-> /g);
        (accumolator[array[0]] !== undefined ?
            accumolator[array[0]] += Number(array[1]) :
            accumolator[array[0]] = Number(array[1]));
        return accumolator;
    }, {}));

    //judge priema tova !!!
    // for (let [key, val] of Object.entries(result)) {
    //     console.log(`${key} : ${val}`);
    // }
}


console.log(
    solve(['Sofia <-> 1200000',
        'Montana <-> 20000',
        'New York <-> 10000000',
        'Washington <-> 2345000',
        'Las Vegas <-> 1000000'])
);

console.log(
    solve(['Istanbul <-> 100000',
        'Honk Kong <-> 2100004',
        'Jerusalem <-> 2352344',
        'Mexico City <-> 23401925',
        'Istanbul <-> 1000'])
)