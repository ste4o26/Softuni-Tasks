function sumOfArrayOfIntegers(array) {
    return array
        .reduce((accumolator, item) => accumolator += item, 0);
}

function sumOfMatrixOfIntegers(matrix) {
    let secondResult = 0;
    matrix.forEach(array => {
        secondResult += array.reduce((accumolator, item) => accumolator += item, 0);
    });

    return secondResult;
}

function isNameContains(name, matrix) {
    // const array = matrix.map(array => array.includes(name));
    // return array.some(item => item === true);

    const array = matrix.reduce((accumolator, currentItem) => accumolator.concat(currentItem));
    // check if at least one of the elements in the collection match the given condtition
    console.log(array);
    return array.some(item => item === name);

    //array.includes(name); -> check if the value is contained in the collection -> works like any in java
}

function minValue(array) {
    function smallerNumber(accumolator, item){
        return (accumolator > item ? item : accumolator);
    }

    return array
        .reduce(smallerNumber, Number.MAX_VALUE);
}

console.log(
    minValue([-1, 10, -2, -87, 95, 15, -100, 1000])
);


// console.log(
//     isNameContains('Ste4o', [
//         ['Pesho', 'Gosho'],
//         ['Abdul', 'Daniel'],
//         ['Valentin', 'Ste4o']
//     ])
// );

// console.log(
//     sumOfArrayOfIntegers([1, 10, 18, -23, 25, 1])
// );

// console.log(
//     sumOfMatrixOfIntegers([
//         [3, 5, 17],
//         [-1, 7, 14],
//         [1, -8, 89]
//     ])
// );