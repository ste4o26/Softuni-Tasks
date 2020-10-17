//have to test the function!!!
const assert = require('chai').assert;

function sum(arr) {
    let sum = 0;
    for (num of arr)
        sum += Number(num);
    return sum;
}


describe('Testing sum function: ', function () {
    it('Should return sum of an array of numbers', function () {
        const array = [1, 2, 3, 4, 5];

        let result = sum(array);

        assert.equal(result, 15);
    })

    it ('Should return NaN if an array of wrong type is passed', function(){
        const array = ['pesho', 'pedal', 'stamat'];

        let result = sum(array);

        assert.isTrue(isNaN(result));
    })

    it('Should return 0 if an empty array is passed', function () {
        const array = [];

        let result = sum(array);

        assert.equal(result, 0);
    })
});

