function solve(n) {
    function add(m) {
        return n + m;
    }

    return add;
}

let addTo5 = solve(5);
console.log(addTo5(2));
console.log(addTo5(3));


let addTo7 = solve(7);
console.log(addTo7(2));
console.log(addTo7(3));