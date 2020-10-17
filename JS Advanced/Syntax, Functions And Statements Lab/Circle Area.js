function solve(n){
    let type = typeof(n);
    let result;
    if (type !== 'number'){
        result = `We can not calculate the circle area, because we receive a ${type}.`;
    }else{
        let area = Math.PI * Math.pow(n, 2);
        result = area.toFixed(2);
    }
    
    return result;
}

console.log(
    solve(5)
);

console.log(
    solve('name')
);