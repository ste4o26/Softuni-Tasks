function solve(array) {
    return array
        .filter(isEvenNumber()) // _ mean that this value will not be use
        .join(" ");
}

function isEvenNumber(){
   return (_, index) => index % 2 === 0;
}

console.log(
    solve(['20', '30', '40'])
);

console.log(
    solve(['5', '10'])
);  