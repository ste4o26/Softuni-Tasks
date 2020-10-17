const rgbToHexColor =  require('./RgbToHex.js');
const assert = require('chai').assert;

describe('Tesitng rgbToHexColor Function: ', function () {
    it('should return undefined if wrong argument/s are passed', function () {
        assert.equal(rgbToHexColor('red', 5, 'blue'), undefined);
        assert.equal(rgbToHexColor(-1, 5, 6), undefined);
        assert.equal(rgbToHexColor(0, 5, 256), undefined);
    });

    it('shuld return hex value of color', function () {
        assert.equal(rgbToHexColor(255, 255, 255), '#FFFFFF');
        assert.equal(rgbToHexColor(0, 0, 0), '#000000');
        assert.equal(rgbToHexColor(8, 230, 15), '#08E60F');

    })
});