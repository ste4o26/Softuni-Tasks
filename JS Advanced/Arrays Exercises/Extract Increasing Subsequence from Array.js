function solve(input) {
    return input
        .reduce((accumolator, item) => {
            // if (accumolator[0] === undefined || accumolator[accumolator.length - 1] <= item) {
            //     accumolator.push(item);
            // }

            if (Math.max(...accumolator) <= item) {
                accumolator.push(item);
            }
            return accumolator;
        }, [])
        .join('\n')
        .trim();
}

console.log(
    solve([1, 3, 3, 8, 4, 10, 12, 3, 2, 24])
);