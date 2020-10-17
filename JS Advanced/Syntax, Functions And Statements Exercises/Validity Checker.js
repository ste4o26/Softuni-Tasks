function solve(data) {
    let x1 = data[0];
    let y1 = data[1];
    let x2 = data[2];
    let y2 = data[3];

    let a = Math.abs(x1 - x2);
    let b = Math.abs(y1 - y2);
    let c = (a * a) + (b * b);

    let isValid = c * c === (a * a) + (b * b);

    if (Number.isInteger(Math.abs(x1 - x2))) {
        console.log(`{${x1}, ${y1}} to {0, 0} is valid`);
    } else {
        console.log(`{${x1}, ${y1}} to {0, 0} is invalid`);
    }

    if (Number.isInteger(Math.abs(y1 - y2))) {
        console.log(`{${x2}, ${y2}} to {0, 0} is valid`);
    } else {
        console.log(`{${x2}, ${y2}} to {0, 0} is invalid`);
    }

    if (Number.isInteger(Math.abs(c * c))) {
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is valid`);
    } else {
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is invalid`);
    }
}

console.log
solve(([2, 1, 1, 1])
);