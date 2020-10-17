function solve(fruit, grams, pricePerKilo){
    let kilograms = (grams / 1000).toFixed(2);
    let moneyNeeded = ((grams * pricePerKilo) / 1000).toFixed(2);
    return `I need $${moneyNeeded} to buy ${kilograms} kilograms ${fruit}.`
}

console.log(
    solve('orange', 2500, 1.80)
);