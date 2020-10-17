//@ts-check
function currencyFormatter(separator, symbol, symbolFirst, value) {
    let result = Math.trunc(value) + separator;
    result += value.toFixed(2).substr(-2, 2);
    if (symbolFirst) return symbol + ' ' + result;
    else return result + ' ' + symbol;
}

function solve(currencyFormatter) {
    let separator = ',';
    let symbol = '$';
    let symbolFirst = true;
        
    function result(value){
        return currencyFormatter(separator, symbol, symbolFirst, value)
    }
    // return `$ ${Math.trunc(value)},${value.toFixed(2).substr(-2, 2)}`;
    return result;
}


let dollarFormatter = solve(currencyFormatter);
console.log(dollarFormatter(5345));   // $ 5345,00 
console.log(dollarFormatter(3.1429)); // $ 3,14 
console.log(dollarFormatter(2.709)); 
