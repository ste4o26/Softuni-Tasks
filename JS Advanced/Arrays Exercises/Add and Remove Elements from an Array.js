function solve(input) {
    const commandsMap = {
        initialValue: 1,
        add: (array) => array.push(commandsMap.initialValue),
        remove: (array) => array.pop()
    };

    const result = input.reduce((a, b) => {
        commandsMap[b](a);
        commandsMap.initialValue++;
        return a;
    }, []).join('\n');

    return result === '' ? 'Empty' : result;
}


console.log(
    solve(['add', 'add', 'remove', 'add', 'add'])
);

console.log(
    solve(['remove', 'remove', 'remove'])
);