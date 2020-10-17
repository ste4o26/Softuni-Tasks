function solve() {
    return {
        __proto__: {},

        extend: function (template) {
            const properties = Object.getOwnPropertyNames(template);
            properties
                .filter(propName => typeof (template[propName]) === 'function')
                .map(funcName => {
                    // this.__proto__[funcName] = template[funcName];
                    // raboti i direktno s manipulaciq na propertito no e po dobrapraktika da polzvam Object.setPrototypeOf()
                    Object.setPrototypeOf(this, template)
                });

            properties
                .filter(propName => typeof (template[propName]) !== 'function')
                .map(propName => {
                    this[propName] = template[propName]
                })
        }
    }
}

const myObj = solve();

myObj.extend({
    extensionMethod: function () { console.log('Hi from template method') },
    extensionProperty: 'someString'
});

console.log(myObj);

myObj.extensionMethod();
console.log(myObj.extensionProperty);