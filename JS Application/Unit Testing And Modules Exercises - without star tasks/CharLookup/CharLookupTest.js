const assert = require('chai').assert;
const charLookup = require('./CharLookup');

describe('Testing charLookup function.', function () {
    it('Should return undefined if one of the arguments are not the required type', function () {
        let actual = charLookup({}, 5);
        assert.isUndefined(actual);

        actual = charLookup([], 5);
        assert.isUndefined(actual);

        actual = charLookup(5, 5);
        assert.isUndefined(actual);

        actual = charLookup(true, 5);
        assert.isUndefined(actual);

        actual = charLookup('string', {});
        assert.isUndefined(actual);

        actual = charLookup('string', []);
        assert.isUndefined(actual);

        actual = charLookup('string', 'anotherOne');
        assert.isUndefined(actual);

        actual = charLookup('string', null);
        assert.isUndefined(actual);
    });

    it('Should return the message "Incorrect index" if the given index is out of bounds', function () {
        let expected = 'Incorrect index';

        let actual = charLookup('string', -1);
        assert.equal(actual, expected);

        actual = charLookup('string', -25);
        assert.equal(actual, expected);

        actual = charLookup('string', 6);
        assert.equal(actual, expected);

        actual = charLookup('string', 10);
        assert.equal(actual, expected);

        actual = charLookup('', 0);
        assert.equal(actual, expected);
    });

    it('Should return the char at the specified index', function () {
        let actual = charLookup('string', 0);
        assert.equal(actual, 's');

        actual = charLookup('string', 5);
        assert.equal(actual, 'g');

        actual = charLookup('string', 3);
        assert.equal(actual, 'i');
    });
});