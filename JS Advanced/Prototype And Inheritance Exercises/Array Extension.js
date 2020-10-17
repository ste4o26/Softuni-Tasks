const result = (function () {
    Array.prototype.last = function () {
        return this[this.length - 1];
    }

    Array.prototype.skip = function (n) {
        return [...this].splice(n, this.length);
    }

    Array.prototype.take = function (n) {
        return [...this].splice(0, n);
    }

    Array.prototype.sum = function () {
        return [...this].reduce((a, b) => a + +b, 0);
    }

    Array.prototype.average = function () {
        return [...this].reduce((a, b) => a + +b, 0) / this.length;
    }

})();


let testArray = [1, 2, 3];
console.log(
    testArray.skip(1)
);