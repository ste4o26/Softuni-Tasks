(function () {
    String.prototype.ensureStart = function (prefix) {
        if (!this.startsWith(prefix)) return prefix.concat(this);
        return this.toString();
    }

    String.prototype.ensureEnd = function (suffix) {
        if (!this.endsWith(suffix)) return this.concat(suffix);
        return this.toString();
    }

    String.prototype.isEmpty = function () {
        if (this.length === 0) return true;
        return false;
    }

    String.prototype.truncate = function (n) {
        const ellipse = '...';
        let word = this.toString().trim();

        if (n < 4) {
            return ellipse.slice(0, n);
        }

        if (word.length <= n) {
            return word;
        }

        if (!word.includes(' ')) {
            return word.slice(0, n - 3) + ellipse;
        }

        while (word.length + ellipse.length > n) {
            console.log(word);
            let words = word.split(' ');
            words.pop();
            word = words.join(' ');
        }

        return word + ellipse;
    }

    String.format = function (string, ...args) {
        for (let i = 0; i < args.length; i++) {
            string = string.replace(`{${i}}`, args[i]);
        }

        return string;
    }
})()


let str = 'my string';

str = str.ensureStart('my');
console.log(str);

str = str.ensureStart('hello ');
console.log(str);

str = str.truncate(16);
console.log(str);

str = str.truncate(14);
console.log(str);

str = str.truncate(8);
console.log(str);

str = str.truncate(4);
console.log(str);

str = str.truncate(2);
console.log(str);

str = String.format('The {0} {1} fox', 'quick', 'brown');
console.log(str);

str = String.format('jumps {0} {1}', 'dog');
console.log(str);