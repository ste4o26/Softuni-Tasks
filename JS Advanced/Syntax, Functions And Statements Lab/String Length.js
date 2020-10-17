function calculateLengthOfStrings(... params){
    let totalLength = 0;
    for (let i = 0; i < params.length; i++) {
        totalLength += params[i].length;
    }
    
    //totalLength = params.reduce((a, b) => a + b.length, 0);

    console.log(totalLength);

    let averageLength = Math.floor(totalLength / params.length);
    console.log(averageLength);
}

calculateLengthOfStrings('chocolate', 'ice cream', 'cake');
calculateLengthOfStrings('pasta', '5', '22.3');