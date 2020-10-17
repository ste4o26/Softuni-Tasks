function solve(n, k) {
    function getElement(array, index, k) {
        let sum = 0;
        for (let i = 0; i < k; i++) {
            const element = array[--index];
            if (typeof (element) === 'undefined') {
                break;
            }
            sum += element;
        }
        return sum;
    }

    const array = [1];
    for (let i = 1; i < n; i++) {
        array[i] = getElement(array, i, k);
    }

    return array.join(" ");
}

console.log(
    solve(6, 3)
);

console.log(
    solve(8, 2)
);