function solve(input) {
    const arena = [];
    for (const line of input) {

        if (line === 'Ave Cesar') {
            break;
        }


        if (line.includes('vs')) {
            let [name1, name2] = line.split(' vs ');
            let firstGladiator = arena.find(glad => Object.keys(glad)[0] === name1);
            let secondGladiator = arena.find(glad => Object.keys(glad)[0] === name2);

            if (firstGladiator !== undefined && secondGladiator !== undefined) {
                let commonTechniques = [];
                let hasCommonTechniques = false;

                let firstGladiatorTotalSkill = 0;
                for (const technique of Object.values(firstGladiator[name1])) {
                    for (const [techniqueName, skill] of Object.entries(technique)) {
                        commonTechniques.push(techniqueName);
                        firstGladiatorTotalSkill += +skill;
                    }
                }

                let secondGladiatorTotalSkill = 0;
                for (const technique of Object.values(secondGladiator[name2])) {
                    for (const [techniqueName, skill] of Object.entries(technique)) {
                        secondGladiatorTotalSkill += +skill;
                        if (commonTechniques.includes(techniqueName)) {
                            hasCommonTechniques = true;
                        }
                    }
                }

                if (hasCommonTechniques) {
                    let firstGladiatorIndex = arena.indexOf(firstGladiator);
                    let secondGladiatorIndex = arena.indexOf(secondGladiator);
                    firstGladiatorTotalSkill < secondGladiatorTotalSkill ? arena.splice(firstGladiatorIndex, 1) : arena.splice(secondGladiatorIndex, 1);
                }
            }

        } else {
            let [name, techniqueName, skill] = line.split(' -> ');

            let gladiator = arena.find(glad => Object.keys(glad)[0] === name);//moje da gurmq zaradi find

            if (gladiator === undefined) {
                const technique = {};
                technique[techniqueName] = skill;

                gladiator = {};
                gladiator[name] = [];
                gladiator[name].push(technique);
                arena.push(gladiator);
            } else {
                techniques = gladiator[name];
                let technique = Object.keys(techniques)
                    .find(key => key === techniqueName);

                if (technique === undefined) {
                    technique = {};
                    technique[techniqueName] = skill;
                    gladiator[name].push(technique);

                } else {
                    if (technique[techniqueName] < skill) {
                        technique[techniqueName] = skill;
                    }
                }
            }
        }
    }


    let sortedGladiators = arena
        .sort((f, s) => {
            

            // let firstGladiatorTotalSkill = 0;
            // for (const technique of Object.values(firstGladiator[name1])) {
            //     for (const [techniqueName, skill] of Object.entries(technique)) {
            //         commonTechniques.push(techniqueName);
            //         firstGladiatorTotalSkill += +skill;
            //     }
            // }

            // let secondGladiatorTotalSkill = 0;
            // for (const technique of Object.values(secondGladiator[name2])) {
            //     for (const [techniqueName, skill] of Object.entries(technique)) {
            //         secondGladiatorTotalSkill += +skill;
            //     }      
            // }

            // return 
        });

    for (const gladiator of arena) {

        //console.log(gladiator);
    }

}
//ordered by total skill in desecending order, then ordered by name in ascending order
solve([
    'Pesho -> BattleCry -> 400',
    'Gosho -> PowerPunch -> 300',
    'Stamat -> Duck -> 200',
    'Stamat -> Tiger -> 250',
    'Ave Cesar'
]);


// solve([
//     'Pesho -> Duck -> 400',
//     'Julius -> Shield -> 150',
//     'Gladius -> Heal -> 200',
//     'Gladius -> Support -> 250',
//     'Gladius -> Shield -> 250',
//     'Pesho vs Gladius',
//     'Gladius vs Julius',
//     'Gladius vs Gosho',
//     'Ave Cesar'
// ]);