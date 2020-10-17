function solve(n){
    let result = '';
    for (let row = 0; row < n; row++) {
        for (let col = 0; col < n; col++) {
            result += '* ';
        }    
        result += '\n';
    }

    return result;
}

console.log(
    solve(5)
);

console.log(
    solve(2)
);

console.log(
    solve(1)
);