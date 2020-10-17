function solve(input) {
    //return input.join(input.pop()); //moje i s pop

    let delimiter = input.slice(input.length - 1);
    return input
        .slice(0, input.length - 1)
        .join(delimiter);

}

console.log(
    solve(['One',
        'Two',
        'Three',
        'Four',
        'Five',
        '-'])
);

console.log(
    solve(['How about no?',
        'I',
        'will',
        'not',
        'do',
        'it!',
        '_'])
);