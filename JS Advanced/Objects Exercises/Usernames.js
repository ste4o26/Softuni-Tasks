function solve(input) {
    const compareByUsernameLengthAndAlphabetically = (f, s) => {
        let result = f.length - s.length;
        return result !== 0 ? result : f.localeCompare(s);
    };

    Object.keys(input.reduce((accumolator, item) => {
        if (!accumolator.hasOwnProperty(item)) {
            accumolator[item] = 0;
        }
        return accumolator;
    }, {}))
        .sort(compareByUsernameLengthAndAlphabetically)
        .forEach(username => console.log(username));
}


console.log(
    solve(['Ashton',
        'Kutcher',
        'Ariel',
        'Lilly',
        'Keyden',
        'Aizen',
        'Billy',
        'Braston'])
);