function solve(steps, sptepsLength, speed) {
    let wholeWay = steps * sptepsLength;

    let totalRestInMinutes = Math.floor(wholeWay / 500);

    let totalTimeInSeconds = Math.ceil(((((wholeWay / speed) / 1000) * 60) + totalRestInMinutes) * 60);

    // return new Date(null, null, null, null, null, totalTimeInSeconds)
    //     .toTimeString()
    //     .split(' ')[0];
    //ekvivalenti !!!
    
    return new Date(totalTimeInSeconds * 1000)
        .toISOString()
        .substr(11, 8);
}

console.log(
    solve(4000, 0.60, 5)
);