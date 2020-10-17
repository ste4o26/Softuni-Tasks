function solve(worker) {
    if (worker.dizziness === true) {
        worker.levelOfHydrated += (worker.weight * 0.1) * worker.experience;
        worker.dizziness = false;
    }

    return worker;
}


console.log(
    solve({
        weight: 80,
        experience: 1,
        levelOfHydrated: 0,
        dizziness: true
    })
);

console.log(
    solve({
        weight: 120,
        experience: 20,
        levelOfHydrated: 200,
        dizziness: true
    })
);
//The required amount is 0.1ml per kilogram per year of experience