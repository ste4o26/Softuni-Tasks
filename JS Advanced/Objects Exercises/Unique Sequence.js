function solve2(input) {
    const uniqueSequences = [];

    input
        .map(array => JSON.parse(array))
        .map(sequence => {
            let sum = sequence.reduce((sum, item) => sum + item, 0);
            let isExistingSequence = uniqueSequences.some(array => {
                return array.reduce((currentArraySum, item) => currentArraySum + item, 0) === sum;
            });

            if (!isExistingSequence) {
                uniqueSequences.push(sequence.sort((f, s) => s - f));
            }
        });

    uniqueSequences
        .sort((f, s) => f.length - s.length)
        .forEach(sequence => console.log(`[${sequence.join(', ')}]`));
}

solve2(["[-3, -2, -1, 0, 1, 2, 3, 4]",
    "[10, 1, -17, 0, 2, 13]",
    "[4, -3, 3, -2, 2, -1, 1, 0]"]);

console.log('\n');

solve2(["[7.14, 7.180, 7.339, 80.099]",
    "[7.339, 80.0990, 7.140000, 7.18]",
    "[7.339, 7.180, 7.14, 80.099]"]);