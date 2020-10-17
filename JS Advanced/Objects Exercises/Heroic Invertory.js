//@ts-check
function solve(input) {
    return JSON.stringify(input
        .map(item => item.split(' / '))
        .reduce((accumolator, heroData) => {
            const hero = {
                name: '',
                level: 0,
                items: []
            };

            let heroItems = []
            if (heroData[2] !== undefined) {
                heroItems = heroData[2].split(', ');
            }

            [hero.name, hero.level, hero.items] = [heroData[0], Number(heroData[1]), heroItems];

            accumolator.push(hero);
            return accumolator;
        }, [])
    );
}

function sovle2(input){
    const heroes = [];
    for (const line of input) {
        let [name, level, items] = line.split(' / ');
        level = Number(level);
        items = (items === undefined ? [] : items.split(', '));
        heroes.push({name, level, items});
        //shtom imenata na promenlivite sa sushtite kato imenata na kliuchovete nqma smisul da slagam :
    }

    return JSON.stringify(heroes);
}

console.log(
    solve(['Isacc / 25 /',
        'Derek / 12 / BarrelVest, DestructionSword',
        'Hes / 1 / Desolator, Sentinel, Antara'])
);