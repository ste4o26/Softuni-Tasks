class data{
    #name;
    #age;

    constructor(name, age){
        this.name = name;
        this.age = age;
    }

    set name(name){
        this.#name = name;
    }

    set age(age){
        this.#age = age;
    }

    toString(){
        return this.#name + this.#age;
    }
}

let a = new data('ste4o', 26);
console.log(a.toString());