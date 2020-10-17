function solve(input) {
    const list = {
        collection: [],
        add: function (string) { this.collection.push(string) },
        remove: function (string) {
            for (let i = 0; i < this.collection.length; i++) {
                if (this.collection[i] === string) this.collection.splice(i, 1);
            }
        },
        print: function () { console.log(this.collection.join(',')) }
    }

    input.forEach(item => {
        let [command, string] = item.split(' ');
        list[command](string);
    });
}

solve(['add hello', 'add again', 'remove hello', 'add again', 'print']);
solve(['add pesho', 'add george', 'add peter', 'remove peter', 'print']);