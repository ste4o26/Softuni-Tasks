class Person {
    #firstName;
    #lastName;
    #fullName;

    constructor(firstName, lastName) {
        this.#firstName = firstName;
        this.#lastName = lastName;
        this.#fullName = `${this.#firstName} ${this.#lastName}`;
    }

    set firstName(firstName) {
        this.#firstName = firstName;
        this.#fullName = `${this.#firstName} ${this.#lastName}`;
    }

    get firstName() {
        return this.#firstName;
    }

    set lastName(lastName) {
        this.#lastName = lastName;
        this.#fullName = `${this.#firstName} ${this.#lastName}`;
    }

    get lastName() {
        return this.#lastName;
    }

    set fullName(fullName) {
        let [firstName, lastName] = fullName.split(' ');
        if (firstName !== undefined && lastName !== undefined) {
            this.#firstName = firstName;
            this.#lastName = lastName;
            this.#fullName = `${this.#firstName} ${this.#lastName}`;
        }
    }

    get fullName() {
        return this.#fullName;
    }
}

let person = new Person("Albert", "Simpson");
console.log(person.fullName);//Albert Simpson 
person.firstName = "Simon";
console.log(person.fullName);//Simon Simpson 
person.fullName = "Peter";
console.log(person.firstName) // Simon 
console.log(person.lastName) // Simpson 