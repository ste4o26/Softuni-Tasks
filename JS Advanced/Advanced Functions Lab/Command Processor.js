let result = (function () {
    let string = '';

    function append(_string) {
        string = string.concat(_string)
    }

    function removeStart(n) {
        string = string.substr(n);
    }

    function removeEnd(n) {
        if (string.length >= n){
            string = string.substr(0, string.length - n);
        }
    }

    function print() {
        console.log(string);
    }

    return {
        append: append,
        removeStart: removeStart,
        removeEnd: removeEnd,
        print: print
    };
})();

result.append('Az sum mnogo umen! A mistin e gei');
result.removeEnd(3);
result.removeStart(3);
result.print();