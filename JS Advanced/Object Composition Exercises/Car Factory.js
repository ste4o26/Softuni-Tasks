function solve(carData) {
    const engines = {
        small: { power: 90, volume: 1800 },
        normal: { power: 120, volume: 2400 },
        monster: { power: 200, volume: 3500 },
    }

    const requiredCarriage = {
        type: carData.carriage,
        color: carData.color
    }

    const requiredEngine = Object.keys(engines).reduce((a, b) => {
        return Math.abs(engines[b].power - carData.power) < Math.abs(engines[a].power - carData.power) ? b : a
    });

    let requiredWheelSize = Math.floor(carData.wheelsize);
    requiredWheelSize = requiredWheelSize % 2 === 0 ? requiredWheelSize - 1 : requiredWheelSize;

    return {
        model: carData.model,
        engine: engines[requiredEngine],
        carriage: requiredCarriage,
        wheels: new Array(4).fill(requiredWheelSize, 0, 4)
    }
}

console.log(
    solve({
        model: 'VW Golf II',
        power: 90,
        color: 'blue',
        carriage: 'hatchback',
        wheelsize: 14
    })
);

console.log(
    solve({
        model: 'Opel Vectra',
        power: 110,
        color: 'grey',
        carriage: 'coupe',
        wheelsize: 17
    })
);