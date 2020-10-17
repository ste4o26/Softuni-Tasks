const assert = require('chai').assert;
const mathEnforcer = require('./MathEnforcer');

describe('Testing mathEnforcer object methoods.', function () {
    describe('Testing addFive mathEnforcer object method.', function () {
        it('Should return undefined when the passed parameter is NAN.', function () {
            let actual = mathEnforcer.addFive('string');
            assert.isUndefined(actual);

            actual = mathEnforcer.addFive(null);
            assert.isUndefined(actual);

            actual = mathEnforcer.addFive({});
            assert.isUndefined(actual);

            actual = mathEnforcer.addFive([]);
            assert.isUndefined(actual);

            actual = mathEnforcer.addFive(true);
            assert.isUndefined(actual);
        });

        it('Should add 5 to the given positive or negative number or floating point number.', function () {
            let actual = mathEnforcer.addFive(5);
            assert.equal(actual, 10);

            actual = mathEnforcer.addFive(-5);
            assert.equal(actual, 0);

            actual = mathEnforcer.addFive(188);
            assert.equal(actual, 193);

            actual = mathEnforcer.addFive(2.5);
            assert.closeTo(actual, 7.5, 0.01);

            actual = mathEnforcer.addFive(-2.5);
            assert.closeTo(actual, 2.5, 0.01);

            actual = mathEnforcer.addFive(0.02);
            assert.closeTo(actual, 5.02, 0.01);
        });
    });

    describe('Testing subtractTen mathEnforcer object method.', function () {
        it('Should return undefined when the passed parameter is NAN.', function () {
            let actual = mathEnforcer.subtractTen('string');
            assert.isUndefined(actual);

            actual = mathEnforcer.subtractTen(null);
            assert.isUndefined(actual);

            actual = mathEnforcer.subtractTen({});
            assert.isUndefined(actual);

            actual = mathEnforcer.subtractTen([]);
            assert.isUndefined(actual);

            actual = mathEnforcer.subtractTen(true);
            assert.isUndefined(actual);
        });

        it('Should subtract 10 from the given positive or negative number or floating point number', function () {
            let actual = mathEnforcer.subtractTen(5);
            assert.equal(actual, -5);

            actual = mathEnforcer.subtractTen(-5);
            assert.equal(actual, -15);

            actual = mathEnforcer.subtractTen(188);
            assert.equal(actual, 178);

            actual = mathEnforcer.subtractTen(2.5);
            assert.closeTo(actual, -7.5, 0.01);

            actual = mathEnforcer.subtractTen(-2.5);
            assert.closeTo(actual, -12.5, 0.01);

            actual = mathEnforcer.subtractTen(15.5);
            assert.closeTo(actual, 5.5, 0.01)

            actual = mathEnforcer.subtractTen(10.02);
            assert.closeTo(actual, 0.02, 0.01);
        });
    });

    describe('Testing sum mathEnforcer object method', function () {
        it('Should return undefined when any of the parameters are NAN.', function () {
            let actual = mathEnforcer.sum('string', 5);
            assert.isUndefined(actual);

            actual = mathEnforcer.sum(5, null);
            assert.isUndefined(actual);

            actual = mathEnforcer.sum({}, 'string');
            assert.isUndefined(actual);

            actual = mathEnforcer.sum(5, []);
            assert.isUndefined(actual);

            actual = mathEnforcer.sum(true, { value: 5 });
            assert.isUndefined(actual);
        });

        it('Should return the sum of the both positive or negative numbers or floating point numbers', function () {
            let actual = mathEnforcer.sum(5, 5);
            assert.equal(actual, 10);

            actual = mathEnforcer.sum(10, -5);
            assert.equal(actual, 5);

            actual = mathEnforcer.sum(-15, 10);
            assert.equal(actual, -5);

            actual = mathEnforcer.sum(10.5, -5.2);
            assert.closeTo(actual, 5.3, 0.01);

            actual = mathEnforcer.sum(-10.8, 5.3);
            assert.closeTo(actual, -5.5, 0.01);

            actual = mathEnforcer.sum(5.02, -3.01);
            assert.closeTo(actual, 2.01, 0.01);
        });
    });
});