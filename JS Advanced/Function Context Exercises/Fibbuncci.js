function getFibonator() {
    let fibNumbers = [0];

    return function () {
        if (fibNumbers.length <= 1) {
            fibNumbers.push(1);
            return 1;
        }

        fibNumbers.push(fibNumbers[fibNumbers.length - 1] + fibNumbers[fibNumbers.length - 2]);
        return fibNumbers[fibNumbers.length - 1];
    }
}

let fib = getFibonator();
console.log(fib()); // 1 
console.log(fib()); // 1 
console.log(fib()); // 2 
console.log(fib()); // 3 
console.log(fib()); // 5 
console.log(fib()); // 8 
console.log(fib()); // 13 