const assert = require('chai').assert;

describe('Array Testing', function () {
    it('should_Return_Minus_One_If_Value_Is_Not_Found', function () {
        //Given
        const array = [1, 2, 3, 400, 12578, 33];

        //When
        let index = array.indexOf(43);

        //Then
        assert.equal(index, -1);
    })
});