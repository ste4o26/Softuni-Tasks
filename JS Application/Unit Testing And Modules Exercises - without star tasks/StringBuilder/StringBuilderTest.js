const assert = require('chai').assert;
const StringBuilder = require('./StringBuilder');
const { expect } = require('chai');

describe('Testing the StringBuider class.', function () {
    describe('Testing the initialization of StringBuilder class.', function () {
        it('Should ceate an empty array of characters when passed parameter is undefined.', function () {
            let sb = new StringBuilder(undefined);
            assert.exists(sb);
            assert.isObject(sb);
            assert.isTrue(sb instanceof StringBuilder);
            assert.isTrue(sb.toString().length === 0);
        });

        it('Should throw TypeError if parameter is not a string.', function () {
            assert.throws(() => new StringBuilder({}), 'Argument must be string');
            assert.throws(() => new StringBuilder(null), 'Argument must be string');
            assert.throws(() => new StringBuilder([]), 'Argument must be string');
            assert.throws(() => new StringBuilder(26), 'Argument must be string');
            assert.throws(() => new StringBuilder(true), 'Argument must be string');
        });

        it('Should create succesffully instace of StringBuilder class with initial array of characters.', function () {
            let sb = new StringBuilder('stirng');
            assert.exists(sb);
            assert.isObject(sb);
            assert.isTrue(sb instanceof StringBuilder);
            assert.equal(sb.toString().length, 6);

            sb = new StringBuilder('');
            assert.exists(sb);
            assert.isObject(sb);
            assert.isTrue(sb instanceof StringBuilder);
            assert.equal(sb.toString().length, 0);
        });
    });

    describe('Testing append method.', function () {
        it('Should throw TypeError if parameter is not a string.', function () {
            let sb = new StringBuilder('string');
            assert.throws(() => sb.append({}), 'Argument must be string');
        });

        it('Should append the passed string argument to the end of the already created string.', function () {
            let sb = new StringBuilder('string');
            sb.append(' is awsome!');
            assert.equal(sb.toString(), 'string is awsome!');
            assert.equal(sb._stringArray.length, 17);
        });
    });

    describe('Testing prepend method.', function () {
        it('Should throw TypeError if parameter is not a string.', function () {
            let sb = new StringBuilder('string');
            assert.throws(() => sb.prepend([]), 'Argument must be string');
        });

        it('Should prepend the passed string argument to the begining of the already created string.', function () {
            let sb = new StringBuilder('string');
            sb.prepend('I love ');
            assert.equal(sb.toString(), 'I love string');
            assert.equal(sb._stringArray.length, 13);
        });
    });

    describe('Testing insertAt method.', function () {
        it('Should throw TypeError if parameter is not a string.', function () {
            let sb = new StringBuilder('string');
            assert.throws(() => sb.prepend(5), 'Argument must be string');
        });

        it('Should insert string argument to already created string starting from the passed index argument.', function () {
            let sb = new StringBuilder('string is awsome!');
            sb.insertAt('absolutely ', 10);
            assert.equal(sb.toString(), 'string is absolutely awsome!');

            sb.insertAt('Hi, ', 0);
            assert.equal(sb.toString(), 'Hi, string is absolutely awsome!');
        });
    });

    describe('Testing remove method.', function () {
        it('Should throw TypeError if parameter is not a string.', function () {
            let sb = new StringBuilder('string');
            assert.throws(() => sb.prepend(true), 'Argument must be string');
        });

        it('Should remove elements from the storage starting from the given index(inclusive), length number of characters.', function () {
            let sb = new StringBuilder('Hi, string is absolutely awsome!');
            sb.remove(13, 11);
            assert.equal(sb.toString(), 'Hi, string is awsome!');

            sb = new StringBuilder('string');
            sb.remove(3, 3);
            assert.equal(sb.toString(), 'str');
        })
    });

    describe('Testing toString method.', function () {
        it('Should return the character array joined by emtpy string.', function () {
            let sb = new StringBuilder('string is awsome!');
            assert.equal(sb.toString(), 'string is awsome!');
        });
    });
});