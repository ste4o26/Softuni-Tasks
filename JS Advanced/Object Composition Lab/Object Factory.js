function solve(input) {
    const data = JSON.parse(input);
    return data.reduce((acc, item) => {
        Object.assign(acc, item);
        return acc;
    }, {});
}

console.log(
    solve(`[{"canMove": true},{"canMove":true, "doors": 4},{"capacity": 5}]`)
);