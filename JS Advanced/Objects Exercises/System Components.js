function solve(input) {
    const register = {};
    for (const line of input) {
        let [systemName, componentName, subcomponentName] = line.split(' | ');

        if (!register.hasOwnProperty(systemName)) {
            register[systemName] = {};
        }

        let components = register[systemName];
        if (!components.hasOwnProperty(componentName)) {
            components[componentName] = [];
        }

        let subcomponents = components[componentName];
        if (!subcomponents.hasOwnProperty(subcomponentName)) {
            subcomponents.push(subcomponentName);
        }
    }

    let sortedSystem = Object.keys(register)
        .sort((f, s) => {
            let result = Object.keys(register[s]).length - Object.keys(register[f]).length;
            return result !== 0 ? result : f.localeCompare(s);
        });

    for (const system of sortedSystem) {
        console.log(system);

        let sortedComponents = Object.keys(register[system])
            .sort((f, s) => {
                return Object.values(register[system][s]).length - Object.values(register[system][f]).length;
            });

        for (const component of sortedComponents) {
            console.log(`|||${component}`);
            register[system][component]
                .forEach(subcomponent => console.log(`||||||${subcomponent}`));
        }
    }
}


solve(['SULS | Main Site | Home Page',
    'SULS | Main Site | Login Page',
    'SULS | Main Site | Register Page',
    'SULS | Judge Site | Login Page',
    'SULS | Judge Site | Submittion Page',
    'Lambda | CoreA | A23',
    'SULS | Digital Site | Login Page',
    'Lambda | CoreB | B24',
    'Lambda | CoreA | A24',
    'Lambda | CoreA | A25',
    'Lambda | CoreC | C4',
    'Indice | Session | Default Storage',
    'Indice | Session | Default Security']);    