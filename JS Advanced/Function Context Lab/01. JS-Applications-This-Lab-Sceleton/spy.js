function Spy(obj, functionName) {
    const originalFunction = obj[functionName];
    let result = {
        count: 0
    };

    obj[functionName] = function () {
        result.count++;
        console.log(arguments);
        originalFunction.apply(this, arguments);
    }

    return result;
}

let obj = {
    method: () => "invoked"
}

let spy = Spy(obj, "method");
obj.method('ni');
obj.method('no');
obj.method();

console.log(spy) // { count: 3 } 