function solve(x, y) {
    let smallest = Math.min(x, y);
    for (let i = smallest; i >= 0; i--) {
        if (x % i == 0 && y % i == 0) {
            return i;
        }
    }

    //vtoro reshenie
    // let copyX = x;
    // let copyY = y;
    // while (copyY !== 0){
    //     [copyX, copyY] = [copyY,copyX % copyY];//tozi izraz e ekvivalent na dolniq
    //     //tova se naricha destructuring => promenlivite ot lqvo prisvoqvat stoinostite 
    //     //na promenlivite ot dqsno po edno i sushto vreme taka nqmam nujda ot vremenna promenliva!!!

    // let temp = copyX % copyY;
    // copyX = copyY;
    // copyY = temp;
}


console.log(
    solve(2154, 458)
);