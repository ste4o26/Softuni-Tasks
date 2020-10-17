const isSymmetric = require('./CheckForSymetry');
const assert = require('chai').assert;

describe('Testing isSymetric function: ', function () {
    it('Should return true if array is symetric', function () {
        let array = [5, 8, 2, 2, 8, 5];
        let result = isSymmetric(array);
        assert.isTrue(result);

        array = ['pesho', 'gosho', 'stamat', 'gosho', 'pesho'];
        result = isSymmetric(array);
        assert.isTrue(result);
    });

    it('Shuld return true if array is semetrycal but of diiferent type of elements', function () {
        let array = [1, 'text', { name: 'John' }, false, { name: 'John' }, 'text', 1];
        result = isSymmetric(array);
        assert.isTrue(result);

        array = ['something', undefined, [], null, [], undefined, 'something'];
        result = isSymmetric(array);
        assert.isTrue(result);
    })

    it('Should return true if empty array is passed', function () {
        array = [];
        result = isSymmetric(array);
        assert.isTrue(result);
    });


    it('should return false if non array is passed', function () {
        let input = {};
        let result = isSymmetric(input);
        assert.isFalse(result);

        input = undefined;
        result = isSymmetric(input);
        assert.isFalse(result);
    });

    it('Should return false if the array is not symetric', function () {
        let array = [5, 3, 2, 1, 4, 5];
        let result = isSymmetric(array);
        assert.isFalse(result);

        array = ['gosho', 'kaloqn', 'ismail'];
        result = isSymmetric(array);
        assert.isFalse(result);
    });
});