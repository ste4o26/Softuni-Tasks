const createCalculator = require('./AddAndSubtract.js');
const assert = require('chai').assert;

describe('Testing createCalculator Function: ', function () {
    it('should create object with add and subtract properties and initial value 0', function () {
        const calc = createCalculator();

        assert.equal(typeof (calc), 'object');
        assert.property(calc, 'add');
        assert.property(calc, 'subtract');
        assert.property(calc, 'get');
        assert.equal(calc.get(), 0);
    });



    it('should add number to current value inside the calculator', function () {
        const calc = createCalculator();
        calc.add(2);
        assert.equal(calc.get(), 2);

        calc.add(5);
        assert.equal(calc.get(), 7);
    });

    it('should add parsable arguments as well', function(){
        const calc = createCalculator();
        calc.add('2');
        assert.equal(calc.get(), 2);

        calc.add('5');
        assert.equal(calc.get(), 7);
    });

    it('should subtract number from current value inside hte calculator', function () {
        const calc = createCalculator();
        calc.subtract(2);
        assert.equal(calc.get(), -2);

        calc.subtract(5);
        assert.equal(calc.get(), -7);
    });

    it('should subtract parsable arguments as well', function(){
        const calc = createCalculator();
        calc.subtract('2');
        assert.equal(calc.get(), -2);

        calc.subtract('5');
        assert.equal(calc.get(), -7);
    });

    it('result should be NaN if non numeric value is passed', function () {
        const calc = createCalculator();

        calc.add(5);
        calc.subtract(2);
        calc.add('ste4o');

        assert.isNaN(calc.get());
    });
});