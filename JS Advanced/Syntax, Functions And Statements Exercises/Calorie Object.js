function solve(data) {
    return data.reduce((accumolator, item, index, array) => {
        if (index % 2 === 0) {
            accumolator[item] = +(array[index + 1]);
        }
        return accumolator;
    }, {});
}

console.log(
    solve(['Yoghurt', '48', 'Rise', '138', 'Apple', '52'])
);