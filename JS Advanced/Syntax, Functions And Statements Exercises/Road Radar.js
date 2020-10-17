function solve(data) {
    const speedLimitInAreas = {
        motorway: 130,
        interstate: 90,
        city: 50,
        residential: 20
    };

    let result = '';
    let speedLimit = speedLimitInAreas[data[1]];

    if (data[0] - speedLimit > 40) {
        return 'reckless driving';
    } else if (data[0] - speedLimit > 20) {
        return 'excessive speeding';
    } else if (data[0] > speedLimit) {
        return 'speeding';  
    }
}

console.log(
    solve([40, 'city'])
);