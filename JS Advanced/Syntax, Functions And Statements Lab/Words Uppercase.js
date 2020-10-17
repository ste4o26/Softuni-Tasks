function solve(someString){
    let result = someString
            .match(/\w+/gim)
            .map(str => str.toUpperCase())
            .join(', ');

    return result;
}

console.log(
    solve('Hi, how are you?')
);