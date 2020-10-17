function solve(...params){
    //can be done with for loop as well!
    let result = params.sort((a, b) => a - b).pop();
    return `The largest number is ${result}.`;
}

console.log(
    solve(5, -3, 16)
);