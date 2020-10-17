const assert = require('chai').assert;
const isOddOrEven = require('./EvenOrOdd');

describe('Testing isOddOrEven Function.', function () {
    it('Should return undefined if the input type is not a string', function () {
        //Given
        let actual = isOddOrEven(5);
        //When
        assert.equal(actual, undefined);
        // assert.isUndefined(actual);
        //Then test should pass becouse i expect undefined

        actual = isOddOrEven(true);
        assert.isUndefined(actual);

        actual = isOddOrEven({});
        assert.isUndefined(actual);

        actual = isOddOrEven([]);
        assert.isUndefined(actual);
    });

    it('Should return even when the length of the sting is even number', function () {
        //Given
        let expected = 'even';
        let actual = isOddOrEven('four');
        //When
        assert.equal(actual, expected);
        //Then test should pass becouse even === even :D

        actual = isOddOrEven('is');
        assert.equal(actual, expected);

        actual = isOddOrEven('');
        assert.equal(actual, expected);

        actual = isOddOrEven('The quick brown fox jumps over the lazy dog.');
        assert.equal(actual, expected);
    });

    it('SHould return odd when the length of the string is odd number', function () {
        //Given
        let expected = 'odd';
        let actual = isOddOrEven('seven');
        //When
        assert.equal(actual, expected);
        //Then -

        actual = isOddOrEven(' ');
        assert.equal(actual, expected);

        actual = isOddOrEven('This is the largest sentence with odd length ever');
        assert.equal(actual, expected);
    });
});