function solve(data, order){
    const compareByOrder = {
        asc: (f, s) => f - s,
        desc: (f, s) => s - f
    };

    return data.sort(compareByOrder[order]);
}


console.log(
    solve([14, 7, 17, 6, 8], 'asc')
);