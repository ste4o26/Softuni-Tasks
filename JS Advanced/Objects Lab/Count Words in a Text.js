function solve(data) {
    const words = data[0].split(/[^\w]+/g);
    return JSON.stringify(words.filter(item => item !== '')
        .reduce((accumolator, property) => {
            accumolator = addPropertyIfMissing(accumolator, property);
            accumolator[property]++;
            return accumolator;
        }, {}));
}


function addPropertyIfMissing(accumolator, property){
    //(accumolator[property] !== undefined ? accumolator[property]++ : accumolator[property] = 1);
    if (accumolator[property] === undefined){
        accumolator[property] = 0;
    }

    return accumolator;
}

console.log(
    solve(['Far too slow, you\'re far too slow.'])
)


console.log(
    solve(['JS devs use Node.js for server-side JS.-- JS for devs'])
)