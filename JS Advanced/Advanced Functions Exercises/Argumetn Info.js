function solve(...input) {
    const descendingValuesByKeysComparator = (f, s) => inputTypeMap[s] - inputTypeMap[f];
    const printFormatedTypesOccurances = key => console.log(`${key} = ${inputTypeMap[key]}`);
    
    const inputTypeMap = input
        .reduce((accumolator, item) => {
            let argumentType = typeof (item);
            console.log(`${argumentType}: ${item}`);

            if (!accumolator.hasOwnProperty(argumentType)) {
                accumolator[argumentType] = 0
            }   

            accumolator[argumentType]++;
            return accumolator;
        }, {});

    Object.keys(inputTypeMap)
        .sort(descendingValuesByKeysComparator)
        .map(printFormatedTypesOccurances);
}

solve('cat', 42, 12, function () { console.log('Hello world!'); });