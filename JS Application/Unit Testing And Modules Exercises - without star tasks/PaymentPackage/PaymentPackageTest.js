const assert = require('chai').assert;
const PaymentPackage = require('./PaymentPackage');

describe('Testing PaymentPackage class methods.', function () {
    describe('Testing object initialization of PaymentPackage class.', function () {
        it('Should throw an error when no parameters are passed', function () {
            assert.throws(() => new PaymentPackage());
        });

        it('Should throw an error when name is not a string or is empty string.', function () {
            assert.throws(() => new PaymentPackage('', 5), 'Name must be a non-empty string');
            assert.throws(() => new PaymentPackage({}, 5), 'Name must be a non-empty string');
            assert.throws(() => new PaymentPackage([], 5), 'Name must be a non-empty string');
            assert.throws(() => new PaymentPackage(5, 5), 'Name must be a non-empty string');
            assert.throws(() => new PaymentPackage(null, 5), 'Name must be a non-empty string');
            assert.throws(() => new PaymentPackage(true, 5), 'Name must be a non-empty string');
            assert.throws(() => new PaymentPackage(undefined, 5), 'Name must be a non-empty string');
        });

        it('Should throw an error when value is not a number or is less then zero.', function () {
            assert.throws(() => new PaymentPackage('string', -1), 'Value must be a non-negative number');
            assert.throws(() => new PaymentPackage('string', {}), 'Value must be a non-negative number');
            assert.throws(() => new PaymentPackage('string', []), 'Value must be a non-negative number');
            assert.throws(() => new PaymentPackage('string', 'anotherString'), 'Value must be a non-negative number');
            assert.throws(() => new PaymentPackage('string', null), 'Value must be a non-negative number');
            assert.throws(() => new PaymentPackage('string', true), 'Value must be a non-negative number');
            assert.throws(() => new PaymentPackage('string', undefined), 'Value must be a non-negative number');
        });

        it('Should create an instance of the PaymentPackage class successfully.', function () {
            let paymentPackage = new PaymentPackage('string', 5);
            assert.exists(paymentPackage, 'paymentPackage object is neither null nor undefined');

            paymentPackage = new PaymentPackage('anotherString', 26);
            assert.exists(paymentPackage, 'paymentPackage object is neither null nor undefined');
        });
    });

    describe('Testing name accessor methods(get / set)', function () {
        it('set name method should set the name property of the obejct to the passed name argument and get name method should return the name.', function () {
            let paymentPackage = new PaymentPackage('string', 5);
            assert.equal(paymentPackage.name, 'string');

            paymentPackage = new PaymentPackage('anotherString', 5);
            assert.equal(paymentPackage.name, 'anotherString');

            paymentPackage = new PaymentPackage('Ste4o26', 5);
            assert.equal(paymentPackage.name, 'Ste4o26');
        });
    });


    describe('Testing value accessor methods(get / set)', function () {
        it('set value method should set the value property of the object to the passed value argument and get value method should return the value', function () {
            let paymentPackage = new PaymentPackage('string', 5);
            assert.equal(paymentPackage.value, 5);

            paymentPackage = new PaymentPackage('string', 15000);
            assert.equal(paymentPackage.value, 15000);

            paymentPackage = new PaymentPackage('string', 1999);
            assert.equal(paymentPackage.value, 1999);
        })
    });


    describe('Testing VAT accessor methods(get / set)', function () {
        it('Should throw an error when invalid VAT argument is passed.', function () {
            let paymentPackage = new PaymentPackage('string', 5);

            assert.throws(() => paymentPackage.VAT = -1, 'VAT must be a non-negative number');
            assert.throw(() => paymentPackage.VAT = 'string', 'VAT must be a non-negative number');
            assert.throw(() => paymentPackage.VAT = {}, 'VAT must be a non-negative number');
            assert.throw(() => paymentPackage.VAT = [], 'VAT must be a non-negative number');
            assert.throw(() => paymentPackage.VAT = true, 'VAT must be a non-negative number');
            assert.throw(() => paymentPackage.VAT = null, 'VAT must be a non-negative number');
        });

        it('set VAT method should set the VAT property of the object to the passed VAT argument and get VAT method should return the VAT', function () {
            let paymentPackage = new PaymentPackage('string', 5);
            assert.equal(paymentPackage.VAT, 20);

            paymentPackage.VAT = 50
            assert.equal(paymentPackage.VAT, 50);

            paymentPackage.VAT = 1999;
            assert.equal(paymentPackage.VAT, 1999);
        });
    });

    describe('Testing active accessor methods(get / set)', function () {
        it('Should throw an error when invalid active argument is passed.', function () {
            let paymentPackage = new PaymentPackage('string', 5);

            assert.throws(() => paymentPackage.active = -1, 'Active status must be a boolean');
            assert.throws(() => paymentPackage.active = 'string', 'Active status must be a boolean');
            assert.throws(() => paymentPackage.active = {}, 'Active status must be a boolean');
            assert.throws(() => paymentPackage.active = [], 'Active status must be a boolean');
            assert.throws(() => paymentPackage.active = 26, 'Active status must be a boolean');
            assert.throws(() => paymentPackage.active = null, 'Active status must be a boolean');
        });

        it('set active method should set the active property of the object to the passed active argument and get active method should return the active', function () {
            let paymentPackage = new PaymentPackage('string', 5);
            assert.equal(paymentPackage.active, true);

            paymentPackage.active = false;
            assert.equal(paymentPackage.active, false);

            paymentPackage.active = false;
            assert.equal(paymentPackage.active, false);

            paymentPackage.active = true;
            assert.equal(paymentPackage.active, true)
        });
    });

    describe('Testing toString method.', function () {
        it('Should display an overview of the instance with active field set to false.', function () {
            let paymentPackage = new PaymentPackage('string', 5);
            paymentPackage.active = false;
            assert.equal(paymentPackage.toString(), 'Package: string (inactive)\n- Value (excl. VAT): 5\n- Value (VAT 20%): 6');

            paymentPackage = new PaymentPackage('Ste4o26', 26);
            paymentPackage.VAT = 50;
            paymentPackage.active = false;
            assert.equal(paymentPackage.toString(), 'Package: Ste4o26 (inactive)\n- Value (excl. VAT): 26\n- Value (VAT 50%): 39');
        });

        it('Should display an overview of the instance with active field set to true.', function () {
            let paymentPackage = new PaymentPackage('string', 5);
            assert.equal(paymentPackage.toString(), 'Package: string\n- Value (excl. VAT): 5\n- Value (VAT 20%): 6');

            paymentPackage = new PaymentPackage('Ste4o26', 26);
            paymentPackage.VAT = 50;
            assert.equal(paymentPackage.toString(), 'Package: Ste4o26\n- Value (excl. VAT): 26\n- Value (VAT 50%): 39');
        });
    });
});