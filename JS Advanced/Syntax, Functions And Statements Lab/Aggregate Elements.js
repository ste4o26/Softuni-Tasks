function solve(firstFunc, secondFunc, thirdFunc, params){
    return firstFunc(params) + 
        '\n' + 
        secondFunc(params) +
        '\n' +
        thirdFunc(params);
}

function sum(params){
    return params.reduce((a, b) => a + b, 0);
}

function sumDrobs(params){
    return params.reduce((a, b) => a + 1/b, 0);
}

function concat(params){
    return params.reduce((a, b) => a + b, '');
}

console.log(
    solve(sum, sumDrobs, concat, [1, 2, 3]),
);