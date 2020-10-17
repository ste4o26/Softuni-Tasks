function manager(input) {
    const microelements = {
        protein: 0,
        carbohydrate: 0,
        fat: 0,
        flavour: 0,
    };

    function restock(ingredient, quantity) {
        microelements[ingredient] += Number(quantity);
        return 'Success';
    }

    function report() {
        return `protein=${microelements.protein} carbohydrate=${microelements.carbohydrate} fat=${microelements.fat} flavour=${microelements.flavour}`;
    }

    function prepare(productMicroelements, actualMicroelements, values) {
        if (actualMicroelements.length === values.length) {
            for (let i = 0; i < actualMicroelements.length; i++) {
                microelements[actualMicroelements[i]] -= values[i];
            }
            return 'Success'
        }

        for (let i = 0; i < productMicroelements.length; i++) {
            if (productMicroelements[i] !== actualMicroelements[i]) {
                return `Error: not enough ${productMicroelements[i]} in stock`;
            }
        }
    }

    let [command, ingredient, quantity] = input.split(' ');
    quantity = Number(quantity);
    switch (command) {
        case 'restock':
            return restock(ingredient, quantity);

        case 'prepare':
            switch (ingredient) {
                case 'apple':
                    const hasAllNeedMicroelementsForApple = key => {
                        return (key === 'carbohydrate' && microelements[key] >= 1) ||
                            (key === 'flavour' && microelements[key] >= 2);
                    };
                    const appleNeededMicroelements = ['carbohydrate', 'flavour'];
                    const appleActualMicroelements = appleNeededMicroelements.filter(hasAllNeedMicroelementsForApple);
                    let appleValues = [1, 2];

                    return prepare(appleNeededMicroelements, appleActualMicroelements, appleValues);

                case 'lemonade':
                    const hasAllNeedMicroelementsForLemonade = key => {
                        return (key === 'carbohydrate' && microelements[key] >= 10) ||
                            (key === 'flavour' && microelements[key] >= 20);
                    };
                    const lemonadeNeededMicroelements = ['carbohydrate', 'flavour'];
                    const lemonadeActualMicroelements = lemonadeNeededMicroelements.filter(hasAllNeedMicroelementsForLemonade);
                    let lemonadeValues = [10, 20];

                    return prepare(lemonadeNeededMicroelements, lemonadeActualMicroelements, lemonadeValues);

                case 'burger':
                    const hasAllNeedMicroelementsForBurger = key => {
                        return (key === 'carbohydrate' && microelements[key] >= 5) ||
                            (key === 'fat' && microelements[key] >= 7) ||
                            (key === 'flavour' && microelements[key] >= 3);
                    };
                    const burgerNeededMicroelements = ['carbohydrate', 'fat', 'flavour'];
                    const burgerActualMicroelements = burgerNeededMicroelements.filter(hasAllNeedMicroelementsForBurger);
                    let burgerValues = [5, 7, 3];

                    return prepare(burgerNeededMicroelements, burgerActualMicroelements, burgerValues);

                case 'eggs':
                    const hasAllNeedMicroelementsForEggs = key => {
                        return (key === 'protein' && microelements[key] >= 5) ||
                            (key === 'fat' && microelements[key] >= 1) ||
                            (key === 'flavour' && microelements[key] >= 1);
                    };
                    const eggsNeededMicroelements = ['protein', 'fat', 'flavour'];
                    const eggsActualMicroelements = eggsNeededMicroelements.filter(hasAllNeedMicroelementsForEggs);
                    let eggsValues = [10, 10, 10, 10];

                    return prepare(eggsNeededMicroelements, eggsActualMicroelements, eggsValues);

                case 'turkey':
                    const hasAllNeedMicroelementsForTurkey = key => {
                        return (key === 'carbohydrate' && microelements[key] >= 10) ||
                            (key === 'flavour' && microelements[key] >= 10) ||
                            (key === 'fat' && microelements[key] >= 10) ||
                            (key === 'protein' && microelements[key] >= 10);
                    };
                    const turkeyNeededMicroelements = Object.keys(microelements);
                    const turkeyActualMicroelements = turkeyNeededMicroelements.filter(hasAllNeedMicroelementsForTurkey);
                    let turkeyValues = [10, 10, 10, 10];

                    return prepare(turkeyNeededMicroelements, turkeyActualMicroelements, turkeyValues);
            }
            break;

        case 'report':
            return report();
    }
}


//test 1: passed
console.log(manager('restock carbohydrate 10'));
console.log(manager('restock flavour 10'));
console.log(manager('prepare apple 1'));
console.log(manager('restock fat 10'));
console.log(manager('prepare burger 1'));
console.log(manager('report'));


//test 2: passed
// console.log(manager('prepare turkey 1'));
// console.log(manager('restock protein 10'));
// console.log(manager('prepare turkey 1'));
// console.log(manager('restock carbohydrate 10'));
// console.log(manager('prepare turkey 1'));
// console.log(manager('restock fat 10'));
// console.log(manager('prepare turkey 1'));
// console.log(manager('restock flavour 10'));
// console.log(manager('prepare turkey 1'));
// console.log(manager('report'));


//test 3: passed
// console.log(manager('restock flavour 50'));
// console.log(manager('prepare lemonade 4'));

//test4 / test5: passed
// console.log(manager('restock protein 100'));
// console.log(manager('restock carbohydrate 100'));
// console.log(manager('restock fat 100'));
// console.log(manager('restock flavour 100'));
// console.log(manager('report'));

//test 6: passed
//console.log(manager('prepare lemonade 4'));

//test 7: unpassed
// console.log(manager('restock protein 100'));
// console.log(manager('restock carbohydrate 100'));
// console.log(manager('restock fat 100'));
// console.log(manager('restock flavour 100'));
// console.log(manager('report'));
// console.log(manager('prepare apple 2'));
// console.log(manager('report'));
// console.log(manager('prepare apple 1'));
// console.log(manager('report'));