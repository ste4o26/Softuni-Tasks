function solve(input) {
    let createCarFactory = function () {
        const cars = {};

        return {
            create: (name) => cars[name] = {},
            inherit: (child, parent) => Object.setPrototypeOf(cars[child], cars[parent]),
            set: (name, key, value) => cars[name][key] = value,
            print: (name) => {
                const carInfo = [];
                for (const key in cars[name]) {
                    carInfo.push(`${key}:${cars[name][key]}`)
                }
                console.log(carInfo.join(', '));
            }
        }
    }

    const carFactory = createCarFactory();
    for (const line of input) {
        const [command, ...args] = line.split(' ');

        if (args.includes('inherit')) {
            carFactory.create(args[0]);
            carFactory.inherit(args[0], args[2]);
        } else {
            carFactory[command](args[0], args[1], args[2]);

        }

        // const name = args[0];
        // switch (command) {
        //     case 'create':
        //         carFactory.create(name);

        //         if (args[1] === 'inherit') {
        //             const parentName = args[2];
        //             carFactory.inherit(name, parentName);
        //         }
        //         break;

        //     case 'set':
        //         carFactory.set(name, args[1], args[2]);
        //         break;

        //     case 'print':
        //         carFactory.print(name);
        //         break;
        // }
    }
}

solve(['create c1',
    'create c2 inherit c1',
    'set c1 color red',
    'set c2 model new',
    'print c1',
    'print c2'])