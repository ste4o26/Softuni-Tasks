function solve(input) {
    const brands = {};
    for (const line of input) {
        let [brand, model, producedCar] = line.split(' | ');
        producedCar = Number(producedCar);

        if (!brands.hasOwnProperty(brand)) {
            brands[brand] = {};
        }

        const car = brands[brand];

        !car.hasOwnProperty(model) ? car[model] = producedCar : car[model] += producedCar;
    }


    for (const [brand, cars] of Object.entries(brands)) {
        console.log(brand)
        for (const car in cars) {
            if (cars.hasOwnProperty(car)) {
                console.log(`###${car} -> ${cars[car]}`);
            }
        }
    }
}


solve(['Audi | Q7 | 1000',
    'Audi | Q6 | 100',
    'BMW | X5 | 1000',
    'BMW | X6 | 100',
    'Citroen | C4 | 123',
    'Volga | GAZ-24 | 1000000',
    'Lada | Niva | 1000000',
    'Lada | Jigula | 1000000',
    'Citroen | C4 | 22',
    'Citroen | C5 | 10']);